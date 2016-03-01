package zyl.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import zyl.model.Stock;
import zyl.model.TuiHuoStock;
import zyl.service.StockService;
import zyl.utils.HttpUtil;

import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name="addStock", location="../../main/addStock.jsp" ),
	@Result(name="getList", location="../../main/deleteStock.jsp" ),
	@Result(name="delete", location="../../main/deleteStock.jsp" ),
	@Result(name="change", location="../../main/changeStock.jsp" ),
	@Result(name="tuihuo", location="../../main/tuihuoStock.jsp" ),
	@Result(name="tuihuoSuccess", location="../../main/tuihuoStock.jsp"),
	@Result(name="getTuiHuoList", location="../../main/lookTuiHuo.jsp")
})
@Namespace("/stock")
public class StockAction extends ActionSupport {
	private static final long serialVersionUID = 8427247339948709332L;
	
	private Stock stock;
	
	private TuiHuoStock tuiHuoStock;
	

	@Action("/addStock")
	public String add() {
		int flag = StockService.getInstance().add(stock);
		if(flag == 1) {
			addActionError("��ӳɹ�");
		} else {
			addActionError("���ʧ��");
		}
		return "addStock";
	}
	
    @Action("/tuihuo")
    public String tuihui() {
    	int flag = StockService.getInstance().tuiHuoStock(tuiHuoStock);
    	if(flag == 1) {
    		addActionError("�˻��ɹ�");
    	} else {
    		addActionError("�˻�ʧ��");
    	}
    	return "tuihuoSuccess";
    }
    
    @Action("/getTuiHuo") 
    public String getTuiHuoList() {
    	List<TuiHuoStock> result = StockService.getInstance().getTuiHuoList();
		HttpServletRequest request = HttpUtil.getRequest();
		if(result.size() > 0) {
			request.setAttribute("list", result);
		} else {
			addActionError("��ʱ��û������");
		}
		return "getTuiHuoList";
    }
	
	@Action("/changeStock")
	public String change() {
		int flag = StockService.getInstance().change(stock);
		if(flag == 1) {
			addActionError("�޸ĳɹ�");
		} else {
			addActionError("�޸�ʧ��");
		}
		return "delete";
	}
	
	@Action("/deleteStock")
	public String delete() {
		HttpServletRequest request = HttpUtil.getRequest();
		String flag = request.getParameter("flag");
		System.out.println("hsd : " + flag);
		if(StringUtils.equals(flag, "1")) {
			Stock result = StockService.getInstance().getStockBy(stock);
			if(result == null) {
				System.out.println("there is no result");
			} else {
				request.setAttribute("stock", result);
				return "tuihuo";
			}
		} else {
			Stock result = StockService.getInstance().getStockBy(stock);
			if(result == null) {
				System.out.println("there is no result");
			} else {
				request.setAttribute("stock", result);
				return "change";
			}
			
		}
		return "delete";
	}
	
	@Action("/list")
	public String getAll() {
		List<Stock> result = StockService.getInstance().getAll();
		HttpServletRequest request = HttpUtil.getRequest();
		if(result.size() > 0) {
			request.setAttribute("list", result);
		} else {
			addActionError("��ʱ��û������");
		}
		return "getList";
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public TuiHuoStock getTuiHuoStock() {
		return tuiHuoStock;
	}

	public void setTuiHuoStock(TuiHuoStock tuiHuoStock) {
		this.tuiHuoStock = tuiHuoStock;
	}
}
