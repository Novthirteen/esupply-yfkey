package com.yfkey.webapp.action;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.progress.open4gl.Parameter;
import com.progress.open4gl.ProDataGraph;
import com.progress.open4gl.ProDataGraphHolder;
import com.progress.open4gl.ProDataObject;
import com.yfkey.model.PurchaseOrderDetail;

/**
 * Action for facilitating Role Management feature.
 */
public class BarcodeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8920999609104602879L;

	private List<PurchaseOrderDetail> purchaseOrderDetails;
	private PurchaseOrderDetail purchaseOrderDetail;

	private InputStream inputStream;
	private String fileName;

	public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
		return purchaseOrderDetails;
	}

	public PurchaseOrderDetail getPurchaseOrderDetail() {
		return purchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		this.purchaseOrderDetail = purchaseOrderDetail;
	}

	public InputStream getInputStream() throws FileNotFoundException {
		return inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	/**
	 * Fetch all purchaseOrders from database and put into local
	 * "purchaseOrders" variable for retrieval in the UI.
	 *
	 * @return "success" if no exceptions thrown
	 */
	public String list() {
		query();
		return SUCCESS;
	}

	private void query() {

		// purchaseOrderDetails = new ArrayList<PurchaseOrderDetail>();

		// PurchaseOrderDetail podet = new PurchaseOrderDetail();
		// podet.setTt_xpyhddeto_seq(new BigDecimal(20));
		// podet.setTt_xpyhddeto_yhdnbr("ORD000001");
		// podet.setTt_xpyhddeto_partnbr("1000001");
		// podet.setTt_xpyhddeto_partdesc("螺丝");
		// podet.setTt_xpyhddeto_spq(new BigDecimal(100));
		// podet.setTt_xpyhddeto_uom("件");
		// podet.setTt_xpyhddeto_innnerqty(new BigDecimal(100));
		// podet.setTt_xpyhddeto_externalqty(new BigDecimal(200));
		// podet.setTt_xpyhddeto_pktype("纸箱");
		// purchaseOrderDetails.add(podet);
		//
		// PurchaseOrderDetail podet1 = new PurchaseOrderDetail();
		// podet1.setTt_xpyhddeto_seq(new BigDecimal(20));
		// podet1.setTt_xpyhddeto_yhdnbr("ORD000001");
		// podet1.setTt_xpyhddeto_partnbr("1000002");
		// podet1.setTt_xpyhddeto_partdesc("螺母");
		// podet1.setTt_xpyhddeto_spq(new BigDecimal(200));
		// podet1.setTt_xpyhddeto_uom("件");
		// podet1.setTt_xpyhddeto_innnerqty(new BigDecimal(200));
		// podet1.setTt_xpyhddeto_externalqty(new BigDecimal(200));
		// podet1.setTt_xpyhddeto_pktype("纸箱");
		// purchaseOrderDetails.add(podet1);
		if (purchaseOrderDetail != null) {
		if (ConnectQAD()) {

			
				List<String> supplierCodeList = getSupplierCodeList(purchaseOrderDetail.getTt_xpyhddeto_suppcode());

				String domain = "YFKSS";
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
				try {
					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_xpyhddet_DSMetaData1());
					for (int i = 0; i < supplierCodeList.size(); i++) {
						ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
						String supCode = supplierCodeList.get(i);
						object.setString(0, domain);
						object.setString(1, supCode);

						exDataGraph.addProDataObject(object);
					}

					ProDataObject objectMstr = exDataGraph.createProDataObject("tt_xpyhddet_in");
					objectMstr.setString(0, domain);

					if (purchaseOrderDetail != null) {

						objectMstr.setString(1, purchaseOrderDetail.getTt_xpyhddeto_yhdnbr());
						objectMstr.setString(2, purchaseOrderDetail.getTt_xpyhddeto_shipto());
						objectMstr.setString(3, purchaseOrderDetail.getTt_xpyhddeto_partnbr());
						objectMstr.setString(4, purchaseOrderDetail.getTt_xpyhddeto_supppart());

					}
					objectMstr.setString(0, domain);

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxinquiry_xpyhddet(exDataGraph, outputData);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

	}

	public String print() throws Exception {
		String localAbsolutPath = this.getSession().getServletContext().getRealPath("/");

		// // 测试
		//
		//
		// purchaseOrderDetails = new ArrayList<PurchaseOrderDetail>();
		// PurchaseOrderDetail podet = new PurchaseOrderDetail();
		// podet.setTt_xpyhddeto_seq(new BigDecimal(10));
		// podet.setTt_xpyhddeto_yhdnbr("ORD000001");
		// podet.setTt_xpyhddeto_partnbr("1000001");
		// podet.setTt_xpyhddeto_partdesc("螺丝");
		// podet.setTt_xpyhddeto_spq(new BigDecimal(100));
		// podet.setTt_xpyhddeto_uom("件");
		// podet.setTt_xpyhddeto_reqqty(new BigDecimal(2000));
		// podet.setTt_xpyhddeto_ordqty(new BigDecimal(2000));
		// purchaseOrderDetails.add(podet);
		//
		// PurchaseOrderDetail podet1 = new PurchaseOrderDetail();
		// podet1.setTt_xpyhddeto_seq(new BigDecimal(20));
		// podet1.setTt_xpyhddeto_yhdnbr("ORD000001");
		// podet1.setTt_xpyhddeto_partnbr("1000002");
		// podet1.setTt_xpyhddeto_partdesc("螺母");
		// podet1.setTt_xpyhddeto_spq(new BigDecimal(100));
		// podet1.setTt_xpyhddeto_uom("件");
		// podet1.setTt_xpyhddeto_reqqty(new BigDecimal(2000));
		// podet1.setTt_xpyhddeto_ordqty(new BigDecimal(2000));
		// purchaseOrderDetails.add(podet1);
		//
		// purchaseOrder.setPurchaseOrderDetailList(purchaseOrderDetails);

		// inputStream = export(localAbsolutPath, "", purchaseOrderDetail);

		fileName = "purchaseOrder_" + purchaseOrderDetail.getTt_xpyhddeto_yhdnbr() + ".pdf";
		return SUCCESS;
	}

}
