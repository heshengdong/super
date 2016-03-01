package zyl.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import zyl.model.SellStock;
import zyl.model.StockManager;
import zyl.model.TuiHuoSellStock;
import zyl.service.SellStockService;
import zyl.service.StockService;
import zyl.utils.HttpUtil;

import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name="sellStock", location="../../main/sellStock.jsp" ),
	@Result(name="sellStockList", location="../../main/operateSellStock.jsp" ),
	@Result(name="tuiHuoSellStock", location="../../main/tuihuoSell.jsp" ),
	@Result(name="tuiHuoList", location="../../main/operateTuiHuoStock.jsp" ),
	@Result(name="stockManager", location="../../main/stockManager.jsp" )
})
@Namespace("/sell")
public class SellAction extends ActionSupport {
	private static final long serialVersionUID = 8427247339948709332L;
	
	private SellStock sellStock;
	
	private TuiHuoSellStock tuiHuoSellStock;
	
	
	@Action("/addSellStock")
	public String add() {
		int flag = SellStockService.getInstance().add(sellStock);
		if(flag == 1) {
			addActionError("添加成功");
		} else {
			addActionError("添加失败");
		}
		return "sellStock";
	}
	
	@Action("/sellStockList")
	public String list() {
		List<SellStock> result = SellStockService.getInstance().getList();
		HttpServletRequest request = HttpUtil.getRequest();
		if(result.size() > 0) {
			request.setAttribute("list", result);
		} else {
			addActionError("暂时没有数据");
		}
		return "sellStockList";
	}
	
	@Action("/tuiHuoSellStock")
	public String tuiHuoSellStock() {
		SellStock result = SellStockService.getInstance().getTuiHuoStock(sellStock);
		HttpServletRequest request = HttpUtil.getRequest();
		request.setAttribute("sellStock", result);
		return "tuiHuoSellStock";
	}
	
	@Action("/getTuiHuoSellList")
	public String getTuiHuoList() {
		List<TuiHuoSellStock> result = SellStockService.getInstance().getTuiHuoSellList();
		HttpServletRequest request = HttpUtil.getRequest();
		if(result.size() > 0) {
			request.setAttribute("list", result);
		} else {
			addActionError("暂时没有数据");
		}
		return "tuiHuoList";
	}
	
	@Action("/stockManagerList")
	public String getStockManagerList() {
		List<StockManager> result = StockService.getInstance().getStockManagerList();
		HttpServletRequest request = HttpUtil.getRequest();
		if(result.size() > 0) {
			request.setAttribute("list", result);
		} else {
			addActionError("暂时没有数据");
		}
		return "stockManager";
	}
	
	@Action("/addTuihuoSell")
	public String addTuiHuo() {
		int flag = SellStockService.getInstance().addTuiHuoStock(tuiHuoSellStock);
		if(flag == 1) {
			addActionError("退货成功");
		} else {
			addActionError("退货失败");
		}
		return "tuiHuoSellStock";
	}


	public SellStock getSellStock() {
		return sellStock;
	}

	public void setSellStock(SellStock sellStock) {
		this.sellStock = sellStock;
	}

	public TuiHuoSellStock getTuiHuoSellStock() {
		return tuiHuoSellStock;
	}

	public void setTuiHuoSellStock(TuiHuoSellStock tuiHuoSellStock) {
		this.tuiHuoSellStock = tuiHuoSellStock;
	}
}
