package zyl.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import zyl.model.ShangPing;
import zyl.service.ShangPingService;
import zyl.utils.HttpUtil;

import com.opensymphony.xwork2.ActionSupport;


@Results({
	@Result(name="addType", location="../../main/addType.jsp" ),
	@Result(name="getListSuccess", location="../../main/deleteType.jsp" ),
	@Result(name="changeShangPing", location="../../main/changeType.jsp" ),
	@Result(name="ChangeSuccess", location="../../../main/deleteType.jsp" )
})
@Namespace("/type")
public class ShangPingAction extends ActionSupport {
	private static final long serialVersionUID = -3793067472465942668L;
	
	private ShangPing shangPin;
	
	
	@Action("/addshangPin")
	public String add() {
		int flag = ShangPingService.getInstance().add(shangPin);
		if(flag == 1) {
			addActionError("添加成功");
		} else {
			addActionError("添加失败");
		}
		return "addType";
	}

	@Action("/getAllShangPin")
	public String getAllList() {
		List<ShangPing> list = ShangPingService.getInstance().getAllList();
		HttpServletRequest request = HttpUtil.getRequest();
		if(list.size() > 0) {
			request.setAttribute("list", list);
		} else {
			addActionError("暂时还没有数据");
		}
		return "getListSuccess";
	}
	
	@Action("/deleteShangPing")
	public String deleteShangPing() {
		HttpServletRequest request = HttpUtil.getRequest();
		String flag_code = request.getParameter("flag");
		if(StringUtils.equals(flag_code, "1")) {
			int flag = ShangPingService.getInstance().delete(shangPin);
			if(flag == 1) {
				addActionError("删除成功");
			} else {
				addActionError("删除失败");
			}
			return "getListSuccess";
			
		} else {
			ShangPing result = ShangPingService.getInstance().getShangPing(shangPin);
			if(result == null) {
				System.out.println("there is no result of code");
				return "getListSuccess";
			}
			request.setAttribute("shangPin", result);
			return "changeShangPing";
		}
		
	}
	
	@Action("changeShangPin")
	public String changeShangPin() {
		int flag = ShangPingService.getInstance().change(shangPin);
		if(flag == 1) {
			addActionError("修改成功");
		} else {
			addActionError("修改失败");
		}
		return "ChangeSuccess";
	}
	
	public ShangPing getShangPin() {
		return shangPin;
	}


	public void setShangPin(ShangPing shangPin) {
		this.shangPin = shangPin;
	}
	

}
