package com.yfkey.qad;

import com.progress.open4gl.dynamicapi.*;
import com.progress.open4gl.javaproxy.*;
import com.progress.open4gl.*;
import com.progress.common.ehnlog.IAppLogger;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.sql.ResultSet;

//
// YFKSSSCP
//
public final class YFKSSSCPImpl extends AppObject
{

    // Create a MetaData object for each temp-table parm used in any and all methods.
    // Create a Schema object for each method call that has temp-table parms which
    // points to one or more temp-tables used in that method call.


	static ProDataGraphMetaData xxcreate_xasndet_DSMetaData1;

	static ProDataObjectMetaData xxcreate_xasndet_MetaData11;

	static ProDataGraphMetaData xxcreate_xasndet_DSMetaData2;

	static ProDataObjectMetaData xxcreate_xasndet_MetaData21;

	static ProDataObjectMetaData xxcreate_xasndet_MetaData22;


	static
	{
		xxcreate_xasndet_DSMetaData1 = new ProDataGraphMetaData(0, "input_xasndet", 1, ParameterSet.INPUT);
		xxcreate_xasndet_MetaData11 = new ProDataObjectMetaData("tt_xasndet_in", 7, false, 0, null, null, null);
		xxcreate_xasndet_MetaData11.setFieldDesc(1, "tt_xasndeti_xpyhddetoid", 0, Parameter.PRO_CHARACTER,0,0);
		xxcreate_xasndet_MetaData11.setFieldDesc(2, "tt_xasndeti_delvqty", 0, Parameter.PRO_DECIMAL,1,0);
		xxcreate_xasndet_MetaData11.setFieldDesc(3, "tt_xasndeti_rmk", 0, Parameter.PRO_CHARACTER,2,0);
		xxcreate_xasndet_MetaData11.setFieldDesc(4, "tt_xasndeti_rmkline", 0, Parameter.PRO_CHARACTER,3,0);
		xxcreate_xasndet_MetaData11.setFieldDesc(5, "tt_xasndeti_creator", 0, Parameter.PRO_CHARACTER,4,0);
		xxcreate_xasndet_MetaData11.setFieldDesc(6, "tt_new_xasndeti_xasndetoid", 0, Parameter.PRO_CHARACTER,5,0);
		xxcreate_xasndet_MetaData11.setFieldDesc(7, "tt_new_xasnmstri_xasnmstroid", 0, Parameter.PRO_CHARACTER,6,0);
		xxcreate_xasndet_DSMetaData1.addTable(xxcreate_xasndet_MetaData11);
		xxcreate_xasndet_DSMetaData2 = new ProDataGraphMetaData(0, "export_xasndet", 2, ParameterSet.OUTPUT);
		xxcreate_xasndet_MetaData21 = new ProDataObjectMetaData("tt_xasndet_out", 3, false, 0, null, null, null);
		xxcreate_xasndet_MetaData21.setFieldDesc(1, "tt_xasndeto_asnnbr", 0, Parameter.PRO_CHARACTER,0,0);
		xxcreate_xasndet_MetaData21.setFieldDesc(2, "tt_xasndeto_xpyhddetoid", 0, Parameter.PRO_CHARACTER,1,0);
		xxcreate_xasndet_MetaData21.setFieldDesc(3, "tt_xasndeto_xasndetoid", 0, Parameter.PRO_CHARACTER,2,0);
		xxcreate_xasndet_DSMetaData2.addTable(xxcreate_xasndet_MetaData21);
		xxcreate_xasndet_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxcreate_xasndet_MetaData22.setFieldDesc(1, "tt_xasndeto_xasndetoid", 0, Parameter.PRO_CHARACTER,0,0);
		xxcreate_xasndet_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxcreate_xasndet_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxcreate_xasndet_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxcreate_xasndet_DSMetaData2.addTable(xxcreate_xasndet_MetaData22);

	}

	static ProDataGraphMetaData xxexport_xasndet_DSMetaData1;

	static ProDataObjectMetaData xxexport_xasndet_MetaData11;

	static ProDataObjectMetaData xxexport_xasndet_MetaData12;

	static ProDataGraphMetaData xxexport_xasndet_DSMetaData2;

	static ProDataObjectMetaData xxexport_xasndet_MetaData21;

	static ProDataObjectMetaData xxexport_xasndet_MetaData22;


	static
	{
		xxexport_xasndet_DSMetaData1 = new ProDataGraphMetaData(0, "input_xasndet", 1, ParameterSet.INPUT);
		xxexport_xasndet_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxexport_xasndet_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxexport_xasndet_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxexport_xasndet_DSMetaData1.addTable(xxexport_xasndet_MetaData11);
		xxexport_xasndet_MetaData12 = new ProDataObjectMetaData("tt_xasndet_in", 7, false, 0, null, null, null);
		xxexport_xasndet_MetaData12.setFieldDesc(1, "tt_xasndeti_asnnbr", 0, Parameter.PRO_CHARACTER,0,0);
		xxexport_xasndet_MetaData12.setFieldDesc(2, "tt_xasndeti_stat", 0, Parameter.PRO_CHARACTER,1,0);
		xxexport_xasndet_MetaData12.setFieldDesc(3, "tt_xasndeti_fromdate", 0, Parameter.PRO_CHARACTER,2,0);
		xxexport_xasndet_MetaData12.setFieldDesc(4, "tt_xasndeti_todate", 0, Parameter.PRO_CHARACTER,3,0);
		xxexport_xasndet_MetaData12.setFieldDesc(5, "tt_xasndeti_shipto", 0, Parameter.PRO_CHARACTER,4,0);
		xxexport_xasndet_MetaData12.setFieldDesc(6, "tt_xasndeti_yhdnbr", 0, Parameter.PRO_CHARACTER,5,0);
		xxexport_xasndet_MetaData12.setFieldDesc(7, "tt_xasndeti_partnbr", 0, Parameter.PRO_CHARACTER,6,0);
		xxexport_xasndet_DSMetaData1.addTable(xxexport_xasndet_MetaData12);
		xxexport_xasndet_DSMetaData2 = new ProDataGraphMetaData(0, "export_xasndet", 2, ParameterSet.OUTPUT);
		xxexport_xasndet_MetaData21 = new ProDataObjectMetaData("tt_xasndet_out", 15, false, 0, null, null, null);
		xxexport_xasndet_MetaData21.setFieldDesc(1, "tt_xasndeto_seq", 0, Parameter.PRO_INTEGER,0,0);
		xxexport_xasndet_MetaData21.setFieldDesc(2, "tt_xasndeto_asnnbr", 0, Parameter.PRO_CHARACTER,1,0);
		xxexport_xasndet_MetaData21.setFieldDesc(3, "tt_xasndeto_shipto", 0, Parameter.PRO_CHARACTER,2,0);
		xxexport_xasndet_MetaData21.setFieldDesc(4, "tt_xasndeto_startdt", 0, Parameter.PRO_CHARACTER,3,0);
		xxexport_xasndet_MetaData21.setFieldDesc(5, "tt_xasndeto_stat", 0, Parameter.PRO_INTEGER,4,0);
		xxexport_xasndet_MetaData21.setFieldDesc(6, "tt_xasndeto_creator", 0, Parameter.PRO_CHARACTER,5,0);
		xxexport_xasndet_MetaData21.setFieldDesc(7, "tt_xasndeto_partnbr", 0, Parameter.PRO_CHARACTER,6,0);
		xxexport_xasndet_MetaData21.setFieldDesc(8, "tt_xasndeto_partdesc", 0, Parameter.PRO_CHARACTER,7,0);
		xxexport_xasndet_MetaData21.setFieldDesc(9, "tt_xasndeto_supppart", 0, Parameter.PRO_CHARACTER,8,0);
		xxexport_xasndet_MetaData21.setFieldDesc(10, "tt_xasndeto_uom", 0, Parameter.PRO_CHARACTER,9,0);
		xxexport_xasndet_MetaData21.setFieldDesc(11, "tt_xasndeto_spq", 0, Parameter.PRO_DECIMAL,10,0);
		xxexport_xasndet_MetaData21.setFieldDesc(12, "tt_xasndeto_asnqty", 0, Parameter.PRO_DECIMAL,11,0);
		xxexport_xasndet_MetaData21.setFieldDesc(13, "tt_xasndeto_xasnmstroid", 0, Parameter.PRO_CHARACTER,12,0);
		xxexport_xasndet_MetaData21.setFieldDesc(14, "tt_xasndeto_xasndetoid", 0, Parameter.PRO_CHARACTER,13,0);
		xxexport_xasndet_MetaData21.setFieldDesc(15, "tt_xasndeto_yhdnbr", 0, Parameter.PRO_CHARACTER,14,0);
		xxexport_xasndet_DSMetaData2.addTable(xxexport_xasndet_MetaData21);
		xxexport_xasndet_MetaData22 = new ProDataObjectMetaData("tt_err_out", 5, false, 0, null, null, null);
		xxexport_xasndet_MetaData22.setFieldDesc(1, "tt_xasndeto_xasnmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxexport_xasndet_MetaData22.setFieldDesc(2, "tt_xasndeto_xasndetoid", 0, Parameter.PRO_CHARACTER,1,0);
		xxexport_xasndet_MetaData22.setFieldDesc(3, "tt_erro_errid", 0, Parameter.PRO_INTEGER,2,0);
		xxexport_xasndet_MetaData22.setFieldDesc(4, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,3,0);
		xxexport_xasndet_MetaData22.setFieldDesc(5, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,4,0);
		xxexport_xasndet_DSMetaData2.addTable(xxexport_xasndet_MetaData22);

	}

	static ProDataGraphMetaData xxexport_xpyhddet_DSMetaData1;

	static ProDataObjectMetaData xxexport_xpyhddet_MetaData11;

	static ProDataObjectMetaData xxexport_xpyhddet_MetaData12;

	static ProDataGraphMetaData xxexport_xpyhddet_DSMetaData2;

	static ProDataObjectMetaData xxexport_xpyhddet_MetaData21;

	static ProDataObjectMetaData xxexport_xpyhddet_MetaData22;


	static
	{
		xxexport_xpyhddet_DSMetaData1 = new ProDataGraphMetaData(0, "input_xpyhddet", 1, ParameterSet.INPUT);
		xxexport_xpyhddet_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxexport_xpyhddet_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxexport_xpyhddet_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxexport_xpyhddet_DSMetaData1.addTable(xxexport_xpyhddet_MetaData11);
		xxexport_xpyhddet_MetaData12 = new ProDataObjectMetaData("tt_xpyhddet_in", 8, false, 0, null, null, null);
		xxexport_xpyhddet_MetaData12.setFieldDesc(1, "tt_xpyhddeti_yhdnbr", 0, Parameter.PRO_CHARACTER,0,0);
		xxexport_xpyhddet_MetaData12.setFieldDesc(2, "tt_xpyhddeti_stat", 0, Parameter.PRO_CHARACTER,1,0);
		xxexport_xpyhddet_MetaData12.setFieldDesc(3, "tt_xpyhddeti_startdt", 0, Parameter.PRO_CHARACTER,2,0);
		xxexport_xpyhddet_MetaData12.setFieldDesc(4, "tt_xpyhddeti_priority", 0, Parameter.PRO_CHARACTER,3,0);
		xxexport_xpyhddet_MetaData12.setFieldDesc(5, "tt_xpyhddeti_creator", 0, Parameter.PRO_CHARACTER,4,0);
		xxexport_xpyhddet_MetaData12.setFieldDesc(6, "tt_xpyhddeti_shipto", 0, Parameter.PRO_CHARACTER,5,0);
		xxexport_xpyhddet_MetaData12.setFieldDesc(7, "tt_xpyhddeti_receptdt", 0, Parameter.PRO_CHARACTER,6,0);
		xxexport_xpyhddet_MetaData12.setFieldDesc(8, "tt_xpyhddeti_partnbr", 0, Parameter.PRO_CHARACTER,7,0);
		xxexport_xpyhddet_DSMetaData1.addTable(xxexport_xpyhddet_MetaData12);
		xxexport_xpyhddet_DSMetaData2 = new ProDataGraphMetaData(0, "export_xpyhddet", 2, ParameterSet.OUTPUT);
		xxexport_xpyhddet_MetaData21 = new ProDataObjectMetaData("tt_xpyhddet_out", 20, false, 0, null, null, null);
		xxexport_xpyhddet_MetaData21.setFieldDesc(1, "tt_xpyhddeto_seq", 0, Parameter.PRO_INTEGER,0,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(2, "tt_xpyhddeto_yhdnbr", 0, Parameter.PRO_CHARACTER,1,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(3, "tt_xpyhddeto_partnbr", 0, Parameter.PRO_CHARACTER,2,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(4, "tt_xpyhddeto_partdesc", 0, Parameter.PRO_CHARACTER,3,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(5, "tt_xpyhddeto_supppart", 0, Parameter.PRO_CHARACTER,4,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(6, "tt_xpyhddeto_suppcode", 0, Parameter.PRO_CHARACTER,5,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(7, "tt_xpyhddeto_shipto", 0, Parameter.PRO_CHARACTER,6,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(8, "tt_xpyhddeto_startdt", 0, Parameter.PRO_CHARACTER,7,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(9, "tt_xpyhddeto_receptdt", 0, Parameter.PRO_CHARACTER,8,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(10, "tt_xpyhddeto_currcy", 0, Parameter.PRO_CHARACTER,9,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(11, "tt_xpyhddeto_uom", 0, Parameter.PRO_CHARACTER,10,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(12, "tt_xpyhddeto_spq", 0, Parameter.PRO_DECIMAL,11,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(13, "tt_xpyhddeto_reqqty", 0, Parameter.PRO_DECIMAL,12,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(14, "tt_xpyhddeto_ordqty", 0, Parameter.PRO_DECIMAL,13,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(15, "tt_xpyhddeto_stat", 0, Parameter.PRO_CHARACTER,14,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(16, "tt_xpyhddeto_priority", 0, Parameter.PRO_CHARACTER,15,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(17, "tt_xpyhddeto_creator", 0, Parameter.PRO_CHARACTER,16,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(18, "tt_xpyhddeto_xpyhmstroid", 0, Parameter.PRO_CHARACTER,17,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(19, "tt_xpyhddeto_xpyhddetoid", 0, Parameter.PRO_CHARACTER,18,0);
		xxexport_xpyhddet_MetaData21.setFieldDesc(20, "tt_xpyhddeto_recepttm", 0, Parameter.PRO_CHARACTER,19,0);
		xxexport_xpyhddet_DSMetaData2.addTable(xxexport_xpyhddet_MetaData21);
		xxexport_xpyhddet_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxexport_xpyhddet_MetaData22.setFieldDesc(1, "tt_erro_xpyhddetoid", 0, Parameter.PRO_CHARACTER,0,0);
		xxexport_xpyhddet_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxexport_xpyhddet_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxexport_xpyhddet_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxexport_xpyhddet_DSMetaData2.addTable(xxexport_xpyhddet_MetaData22);

	}

	static ProDataGraphMetaData xxinquiry_xprcdet_DSMetaData1;

	static ProDataObjectMetaData xxinquiry_xprcdet_MetaData11;

	static ProDataGraphMetaData xxinquiry_xprcdet_DSMetaData2;

	static ProDataObjectMetaData xxinquiry_xprcdet_MetaData21;

	static ProDataObjectMetaData xxinquiry_xprcdet_MetaData22;


	static
	{
		xxinquiry_xprcdet_DSMetaData1 = new ProDataGraphMetaData(0, "input_xprcd", 1, ParameterSet.INPUT);
		xxinquiry_xprcdet_MetaData11 = new ProDataObjectMetaData("tt_xprcdet_in", 1, false, 0, null, null, null);
		xxinquiry_xprcdet_MetaData11.setFieldDesc(1, "tt_xprcdeti_xprcmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xprcdet_DSMetaData1.addTable(xxinquiry_xprcdet_MetaData11);
		xxinquiry_xprcdet_DSMetaData2 = new ProDataGraphMetaData(0, "export_xprcd", 2, ParameterSet.OUTPUT);
		xxinquiry_xprcdet_MetaData21 = new ProDataObjectMetaData("tt_xprcdet_out", 28, false, 0, null, null, null);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(1, "tt_xpyhddeto_voucher", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(2, "tt_xpyhddeto_partnbr", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(3, "tt_xpyhddeto_receiver", 0, Parameter.PRO_CHARACTER,2,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(4, "tt_xpyhddeto_seq", 0, Parameter.PRO_INTEGER,3,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(5, "tt_xpyhddeto_poprice", 0, Parameter.PRO_DECIMAL,4,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(6, "tt_xpyhddeto_uom", 0, Parameter.PRO_CHARACTER,5,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(7, "tt_xpyhddeto_invprice", 0, Parameter.PRO_DECIMAL,6,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(8, "tt_xpyhddeto_invamt", 0, Parameter.PRO_DECIMAL,7,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(9, "tt_xpyhddeto_partdesc", 0, Parameter.PRO_CHARACTER,8,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(10, "tt_xpyhddeto_rcdate", 0, Parameter.PRO_CHARACTER,9,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(11, "tt_xpyhddeto_qty", 0, Parameter.PRO_INTEGER,10,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(12, "tt_xpyhddeto_taxamt", 0, Parameter.PRO_DECIMAL,11,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(13, "tt_xpyhddeto_invdate", 0, Parameter.PRO_CHARACTER,12,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(14, "tt_xpyhddeto_notaxamt", 0, Parameter.PRO_DECIMAL,13,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(15, "tt_xpyhddeto_totalamt", 0, Parameter.PRO_DECIMAL,14,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(16, "tt_xpyhddeto_invnbr", 0, Parameter.PRO_CHARACTER,15,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(17, "tt_xpyhddeto_rmk", 0, Parameter.PRO_CHARACTER,16,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(18, "tt_xpyhddeto_claiminv", 0, Parameter.PRO_CHARACTER,17,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(19, "tt_xpyhddeto_claimamt", 0, Parameter.PRO_DECIMAL,18,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(20, "tt_xpyhddeto_suppcode", 0, Parameter.PRO_CHARACTER,19,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(21, "tt_xpyhddeto_stat", 0, Parameter.PRO_CHARACTER,20,0);	
		xxinquiry_xprcdet_MetaData21.setFieldDesc(22, "tt_xpyhddeto_xprcmstroid", 0, Parameter.PRO_CHARACTER,21,0);	
		xxinquiry_xprcdet_MetaData21.setFieldDesc(23, "tt_xpyhddeto_rcqty", 0, Parameter.PRO_DECIMAL,22,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(24, "tt_xpyhddeto_indexinvnbr", 0, Parameter.PRO_CHARACTER,23,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(25, "tt_xpyhddeto_disamt", 0, Parameter.PRO_DECIMAL,24,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(26, "tt_xpyhddeto_spname", 0, Parameter.PRO_CHARACTER,25,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(27, " tt_xpyhddeto_ponbr", 0, Parameter.PRO_CHARACTER,26,0);
		xxinquiry_xprcdet_MetaData21.setFieldDesc(28, " tt_xpyhddeto_asn", 0, Parameter.PRO_CHARACTER,27,0);
		xxinquiry_xprcdet_DSMetaData2.addTable(xxinquiry_xprcdet_MetaData21);
		xxinquiry_xprcdet_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxinquiry_xprcdet_MetaData22.setFieldDesc(1, "tt_erro_xprcdetoid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xprcdet_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxinquiry_xprcdet_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxinquiry_xprcdet_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_xprcdet_DSMetaData2.addTable(xxinquiry_xprcdet_MetaData22);

	}

	static ProDataGraphMetaData xxinquiry_xprcmstr_DSMetaData1;

	static ProDataObjectMetaData xxinquiry_xprcmstr_MetaData11;

	static ProDataObjectMetaData xxinquiry_xprcmstr_MetaData12;

	static ProDataGraphMetaData xxinquiry_xprcmstr_DSMetaData2;

	static ProDataObjectMetaData xxinquiry_xprcmstr_MetaData21;

	static ProDataObjectMetaData xxinquiry_xprcmstr_MetaData22;


	static
	{
		xxinquiry_xprcmstr_DSMetaData1 = new ProDataGraphMetaData(0, "input_xprc", 1, ParameterSet.INPUT);
		xxinquiry_xprcmstr_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxinquiry_xprcmstr_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xprcmstr_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_xprcmstr_DSMetaData1.addTable(xxinquiry_xprcmstr_MetaData11);
		xxinquiry_xprcmstr_MetaData12 = new ProDataObjectMetaData("tt_xprcmstr_in", 4, false, 0, null, null, null);
		xxinquiry_xprcmstr_MetaData12.setFieldDesc(1, "tt_xprcmstri_voucher", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xprcmstr_MetaData12.setFieldDesc(2, "tt_xprcmstri_fromdate", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_xprcmstr_MetaData12.setFieldDesc(3, "tt_xprcmstri_todate", 0, Parameter.PRO_CHARACTER,2,0);
		xxinquiry_xprcmstr_MetaData12.setFieldDesc(4, "tt_xprcmstri_stat", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_xprcmstr_DSMetaData1.addTable(xxinquiry_xprcmstr_MetaData12);
		xxinquiry_xprcmstr_DSMetaData2 = new ProDataGraphMetaData(0, "export_xprc", 2, ParameterSet.OUTPUT);
		xxinquiry_xprcmstr_MetaData21 = new ProDataObjectMetaData("tt_xprcmstr_out", 9, false, 0, null, null, null);
		xxinquiry_xprcmstr_MetaData21.setFieldDesc(1, "tt_xprcmstro_seq", 0, Parameter.PRO_INTEGER,0,0);
		xxinquiry_xprcmstr_MetaData21.setFieldDesc(2, "tt_xprcmstro_voucher", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_xprcmstr_MetaData21.setFieldDesc(3, "tt_xprcmstro_suppcode", 0, Parameter.PRO_CHARACTER,2,0);
		xxinquiry_xprcmstr_MetaData21.setFieldDesc(4, "tt_xprcmstro_invdate", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_xprcmstr_MetaData21.setFieldDesc(5, "tt_xprcmstro_totalamt", 0, Parameter.PRO_DECIMAL,4,0);
		xxinquiry_xprcmstr_MetaData21.setFieldDesc(6, "tt_xprcmstro_printed", 0, Parameter.PRO_CHARACTER,5,0);
		xxinquiry_xprcmstr_MetaData21.setFieldDesc(7, "tt_xprcmstro_stat", 0, Parameter.PRO_CHARACTER,6,0);
		xxinquiry_xprcmstr_MetaData21.setFieldDesc(8, "tt_xprcmstro_xprcmstroid", 0, Parameter.PRO_CHARACTER,7,0);
		xxinquiry_xprcmstr_MetaData21.setFieldDesc(9, "tt_xprcmstro_type", 0, Parameter.PRO_CHARACTER,8,0);
		xxinquiry_xprcmstr_DSMetaData2.addTable(xxinquiry_xprcmstr_MetaData21);
		xxinquiry_xprcmstr_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxinquiry_xprcmstr_MetaData22.setFieldDesc(1, "tt_erro_xprcmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xprcmstr_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxinquiry_xprcmstr_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxinquiry_xprcmstr_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_xprcmstr_DSMetaData2.addTable(xxinquiry_xprcmstr_MetaData22);

	}

	static ProDataGraphMetaData xxinquiry_xpyhddet_DSMetaData1;

	static ProDataObjectMetaData xxinquiry_xpyhddet_MetaData11;

	static ProDataObjectMetaData xxinquiry_xpyhddet_MetaData12;

	static ProDataGraphMetaData xxinquiry_xpyhddet_DSMetaData2;

	static ProDataObjectMetaData xxinquiry_xpyhddet_MetaData21;

	static ProDataObjectMetaData xxinquiry_xpyhddet_MetaData22;


	static
	{
		xxinquiry_xpyhddet_DSMetaData1 = new ProDataGraphMetaData(0, "input_xpyhddet", 1, ParameterSet.INPUT);
		xxinquiry_xpyhddet_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxinquiry_xpyhddet_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xpyhddet_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_xpyhddet_DSMetaData1.addTable(xxinquiry_xpyhddet_MetaData11);
		xxinquiry_xpyhddet_MetaData12 = new ProDataObjectMetaData("tt_xpyhddet_in", 5, false, 0, null, null, null);
		xxinquiry_xpyhddet_MetaData12.setFieldDesc(1, "tt_xpyhddeti_yhdnbr", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xpyhddet_MetaData12.setFieldDesc(2, "tt_xpyhddeti_shipto", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_xpyhddet_MetaData12.setFieldDesc(3, "tt_xpyhddeti_partnbr", 0, Parameter.PRO_CHARACTER,2,0);
		xxinquiry_xpyhddet_MetaData12.setFieldDesc(4, "tt_xpyhddeti_supppart", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_xpyhddet_MetaData12.setFieldDesc(5, "tt_xpyhddeti_asn", 0, Parameter.PRO_CHARACTER,4,0);
		xxinquiry_xpyhddet_DSMetaData1.addTable(xxinquiry_xpyhddet_MetaData12);
		xxinquiry_xpyhddet_DSMetaData2 = new ProDataGraphMetaData(0, "export_xpyhddet", 2, ParameterSet.OUTPUT);
		xxinquiry_xpyhddet_MetaData21 = new ProDataObjectMetaData("tt_xpyhddet_out", 13, false, 0, null, null, null);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(1, "tt_xpyhddeto_seq", 0, Parameter.PRO_INTEGER,0,0);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(2, "tt_xpyhddeto_yhdnbr", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(3, "tt_xpyhddeto_partnbr", 0, Parameter.PRO_CHARACTER,2,0);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(4, "tt_xpyhddeto_partdesc", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(5, "tt_xpyhddeto_supppart", 0, Parameter.PRO_CHARACTER,4,0);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(6, "tt_xpyhddeto_uom", 0, Parameter.PRO_CHARACTER,5,0);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(7, "tt_xpyhddeto_innnerqty", 0, Parameter.PRO_DECIMAL,6,0);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(8, "tt_xpyhddeto_externalqty", 0, Parameter.PRO_DECIMAL,7,0);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(9, "tt_xpyhddeto_pktype", 0, Parameter.PRO_CHARACTER,8,0);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(10, "tt_xpyhddeto_lots", 0, Parameter.PRO_CHARACTER,9,0);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(11, "tt_xpyhddeto_qty", 0, Parameter.PRO_DECIMAL,10,0);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(12, "tt_xpyhddeto_suppcode", 0, Parameter.PRO_CHARACTER,11,0);
		xxinquiry_xpyhddet_MetaData21.setFieldDesc(13, "tt_xpyhddeto_xpyhddetoid", 0, Parameter.PRO_CHARACTER,12,0);
		xxinquiry_xpyhddet_DSMetaData2.addTable(xxinquiry_xpyhddet_MetaData21);
		xxinquiry_xpyhddet_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxinquiry_xpyhddet_MetaData22.setFieldDesc(1, "tt_erro_xpyhddetoid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xpyhddet_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxinquiry_xpyhddet_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxinquiry_xpyhddet_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_xpyhddet_DSMetaData2.addTable(xxinquiry_xpyhddet_MetaData22);

	}

	static ProDataGraphMetaData xxinquiry_xpyhmstr_DSMetaData1;

	static ProDataObjectMetaData xxinquiry_xpyhmstr_MetaData11;

	static ProDataObjectMetaData xxinquiry_xpyhmstr_MetaData12;

	static ProDataGraphMetaData xxinquiry_xpyhmstr_DSMetaData2;

	static ProDataObjectMetaData xxinquiry_xpyhmstr_MetaData21;

	static ProDataObjectMetaData xxinquiry_xpyhmstr_MetaData22;


	static
	{
		xxinquiry_xpyhmstr_DSMetaData1 = new ProDataGraphMetaData(0, "input_xpyhmstr", 1, ParameterSet.INPUT);
		xxinquiry_xpyhmstr_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxinquiry_xpyhmstr_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xpyhmstr_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_xpyhmstr_DSMetaData1.addTable(xxinquiry_xpyhmstr_MetaData11);
		xxinquiry_xpyhmstr_MetaData12 = new ProDataObjectMetaData("tt_xpyhmstr_in", 10, false, 0, null, null, null);
		xxinquiry_xpyhmstr_MetaData12.setFieldDesc(1, "tt_xpyhmstri_yhdnbr", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xpyhmstr_MetaData12.setFieldDesc(2, "tt_xpyhmstri_stat", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_xpyhmstr_MetaData12.setFieldDesc(3, "tt_xpyhmstri_startdt", 0, Parameter.PRO_CHARACTER,2,0);
		xxinquiry_xpyhmstr_MetaData12.setFieldDesc(4, "tt_xpyhmstri_priority", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_xpyhmstr_MetaData12.setFieldDesc(5, "tt_xpyhmstri_creator", 0, Parameter.PRO_CHARACTER,4,0);
		xxinquiry_xpyhmstr_MetaData12.setFieldDesc(6, "tt_xpyhmstri_shipto", 0, Parameter.PRO_CHARACTER,5,0);
		xxinquiry_xpyhmstr_MetaData12.setFieldDesc(7, "tt_xpyhmstri_receptdt", 0, Parameter.PRO_CHARACTER,6,0);
		xxinquiry_xpyhmstr_MetaData12.setFieldDesc(8, "tt_xpyhmstri_partnbr", 0, Parameter.PRO_CHARACTER,7,0);
		xxinquiry_xpyhmstr_MetaData12.setFieldDesc(9, "tt_xpyhmstri_type", 0, Parameter.PRO_CHARACTER,8,0);
		xxinquiry_xpyhmstr_MetaData12.setFieldDesc(10, "tt_xpyhmstri_enddt", 0, Parameter.PRO_CHARACTER,9,0);
		xxinquiry_xpyhmstr_DSMetaData1.addTable(xxinquiry_xpyhmstr_MetaData12);
		xxinquiry_xpyhmstr_DSMetaData2 = new ProDataGraphMetaData(0, "export_xpyhmstr", 2, ParameterSet.OUTPUT);
		xxinquiry_xpyhmstr_MetaData21 = new ProDataObjectMetaData("tt_xpyhmstr_out", 13, false, 0, null, null, null);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(1, "tt_xpyhmstro_seq", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(2, "tt_xpyhmstro_yhdnbr", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(3, "tt_xpyhmstro_suppcode", 0, Parameter.PRO_CHARACTER,2,0);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(4, "tt_xpyhmstro_shipto", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(5, "tt_xpyhmstro_startdt", 0, Parameter.PRO_CHARACTER,4,0);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(6, "tt_xpyhmstro_receptdt", 0, Parameter.PRO_CHARACTER,5,0);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(7, "tt_xpyhmstro_stat", 0, Parameter.PRO_CHARACTER,6,0);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(8, "tt_xpyhmstro_priority", 0, Parameter.PRO_CHARACTER,7,0);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(9, "tt_xpyhmstro_creator", 0, Parameter.PRO_CHARACTER,8,0);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(10, "tt_xpyhmstro_xpyhmstroid", 0, Parameter.PRO_CHARACTER,9,0);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(11, "tt_xpyhmstro_conf", 0, Parameter.PRO_CHARACTER,10,0);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(12, "tt_xpyhmstro_print", 0, Parameter.PRO_CHARACTER,11,0);
		xxinquiry_xpyhmstr_MetaData21.setFieldDesc(13, "tt_xpyhmstro_recepttm", 0, Parameter.PRO_CHARACTER,12,0);
		xxinquiry_xpyhmstr_DSMetaData2.addTable(xxinquiry_xpyhmstr_MetaData21);
		xxinquiry_xpyhmstr_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxinquiry_xpyhmstr_MetaData22.setFieldDesc(1, "tt_erro_xpyhmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_xpyhmstr_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxinquiry_xpyhmstr_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxinquiry_xpyhmstr_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_xpyhmstr_DSMetaData2.addTable(xxinquiry_xpyhmstr_MetaData22);

	}

	static ProDataGraphMetaData xxinqury_prhdet_DSMetaData1;

	static ProDataObjectMetaData xxinqury_prhdet_MetaData11;

	static ProDataObjectMetaData xxinqury_prhdet_MetaData12;

	static ProDataGraphMetaData xxinqury_prhdet_DSMetaData2;

	static ProDataObjectMetaData xxinqury_prhdet_MetaData21;

	static ProDataObjectMetaData xxinqury_prhdet_MetaData22;


	static
	{
		xxinqury_prhdet_DSMetaData1 = new ProDataGraphMetaData(0, "input_prhdet", 1, ParameterSet.INPUT);
		xxinqury_prhdet_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxinqury_prhdet_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxinqury_prhdet_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxinqury_prhdet_DSMetaData1.addTable(xxinqury_prhdet_MetaData11);
		xxinqury_prhdet_MetaData12 = new ProDataObjectMetaData("tt_prhdet_in", 6, false, 0, null, null, null);
		xxinqury_prhdet_MetaData12.setFieldDesc(1, "tt_prhdeti_receiver", 0, Parameter.PRO_CHARACTER,0,0);
		xxinqury_prhdet_MetaData12.setFieldDesc(2, "tt_prhdeti_fromdate", 0, Parameter.PRO_CHARACTER,1,0);
		xxinqury_prhdet_MetaData12.setFieldDesc(3, "tt_prhdeti_todate", 0, Parameter.PRO_CHARACTER,2,0);
		xxinqury_prhdet_MetaData12.setFieldDesc(4, "tt_prhdeti_yhdnbr", 0, Parameter.PRO_CHARACTER,3,0);
		xxinqury_prhdet_MetaData12.setFieldDesc(5, "tt_prhdeti_partnbr", 0, Parameter.PRO_CHARACTER,4,0);
		xxinqury_prhdet_MetaData12.setFieldDesc(6, "tt_prhdeti_asnnbr", 0, Parameter.PRO_CHARACTER,5,0);
		xxinqury_prhdet_DSMetaData1.addTable(xxinqury_prhdet_MetaData12);
		xxinqury_prhdet_DSMetaData2 = new ProDataGraphMetaData(0, "export_prhdet", 2, ParameterSet.OUTPUT);
		xxinqury_prhdet_MetaData21 = new ProDataObjectMetaData("tt_prhdet_out", 20, false, 0, null, null, null);
		xxinqury_prhdet_MetaData21.setFieldDesc(1, "tt_prhdeto_seq", 0, Parameter.PRO_INTEGER,0,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(2, "tt_prhdeto_receiver", 0, Parameter.PRO_CHARACTER,1,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(3, "tt_prhdeto_suppcode", 0, Parameter.PRO_CHARACTER,2,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(4, "tt_prhdeto_asnnbr", 0, Parameter.PRO_CHARACTER,3,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(5, "tt_prhdeto_shipto", 0, Parameter.PRO_CHARACTER,4,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(6, "tt_prhdeto_rcdate", 0, Parameter.PRO_CHARACTER,5,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(7, "tt_prhdeto_rcuserid", 0, Parameter.PRO_CHARACTER,6,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(8, "tt_prhdeto_prhmstroid", 0, Parameter.PRO_CHARACTER,7,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(9, "tt_prhdeto_shipfrom", 0, Parameter.PRO_CHARACTER,8,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(10, "tt_prhdeto_yhdnbr", 0, Parameter.PRO_CHARACTER,9,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(11, "tt_prhdeto_partnbr", 0, Parameter.PRO_CHARACTER,10,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(12, "tt_prhdeto_partdesc", 0, Parameter.PRO_CHARACTER,11,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(13, "tt_prhdeto_supppart", 0, Parameter.PRO_CHARACTER,12,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(14, "tt_prhdeto_uom", 0, Parameter.PRO_CHARACTER,13,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(15, "tt_prhdeto_spq", 0, Parameter.PRO_DECIMAL,14,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(16, "tt_prhdeto_toloc", 0, Parameter.PRO_CHARACTER,15,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(17, "tt_prhdeto_delvqty", 0, Parameter.PRO_DECIMAL,16,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(18, "tt_prhdeto_revdqty", 0, Parameter.PRO_DECIMAL,17,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(19, "tt_prhdeto_vendname", 0, Parameter.PRO_CHARACTER,18,0);
		xxinqury_prhdet_MetaData21.setFieldDesc(20, "tt_prhdeto_shipaddr", 0, Parameter.PRO_CHARACTER,19,0);
		xxinqury_prhdet_DSMetaData2.addTable(xxinqury_prhdet_MetaData21);
		xxinqury_prhdet_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxinqury_prhdet_MetaData22.setFieldDesc(1, "tt_erro_prhmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinqury_prhdet_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxinqury_prhdet_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxinqury_prhdet_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxinqury_prhdet_DSMetaData2.addTable(xxinqury_prhdet_MetaData22);

	}

	static ProDataGraphMetaData xxinqury_prhmstr_DSMetaData1;

	static ProDataObjectMetaData xxinqury_prhmstr_MetaData11;

	static ProDataObjectMetaData xxinqury_prhmstr_MetaData12;

	static ProDataGraphMetaData xxinqury_prhmstr_DSMetaData2;

	static ProDataObjectMetaData xxinqury_prhmstr_MetaData21;

	static ProDataObjectMetaData xxinqury_prhmstr_MetaData22;


	static
	{
		xxinqury_prhmstr_DSMetaData1 = new ProDataGraphMetaData(0, "input_prhmstr", 1, ParameterSet.INPUT);
		xxinqury_prhmstr_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxinqury_prhmstr_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxinqury_prhmstr_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxinqury_prhmstr_DSMetaData1.addTable(xxinqury_prhmstr_MetaData11);
		xxinqury_prhmstr_MetaData12 = new ProDataObjectMetaData("tt_prhmstr_in", 6, false, 0, null, null, null);
		xxinqury_prhmstr_MetaData12.setFieldDesc(1, "tt_prhmstri_receiver", 0, Parameter.PRO_CHARACTER,0,0);
		xxinqury_prhmstr_MetaData12.setFieldDesc(2, "tt_prhmstri_fromdate", 0, Parameter.PRO_CHARACTER,1,0);
		xxinqury_prhmstr_MetaData12.setFieldDesc(3, "tt_prhmstri_todate", 0, Parameter.PRO_CHARACTER,2,0);
		xxinqury_prhmstr_MetaData12.setFieldDesc(4, "tt_prhmstri_yhdnbr", 0, Parameter.PRO_CHARACTER,3,0);
		xxinqury_prhmstr_MetaData12.setFieldDesc(5, "tt_prhmstri_partnbr", 0, Parameter.PRO_CHARACTER,4,0);
		xxinqury_prhmstr_MetaData12.setFieldDesc(6, "tt_prhmstri_asnnbr", 0, Parameter.PRO_CHARACTER,5,0);
		xxinqury_prhmstr_DSMetaData1.addTable(xxinqury_prhmstr_MetaData12);
		xxinqury_prhmstr_DSMetaData2 = new ProDataGraphMetaData(0, "export_prhmstr", 2, ParameterSet.OUTPUT);
		xxinqury_prhmstr_MetaData21 = new ProDataObjectMetaData("tt_prhmstr_out", 8, false, 0, null, null, null);
		xxinqury_prhmstr_MetaData21.setFieldDesc(1, "tt_prhmstro_seq", 0, Parameter.PRO_INTEGER,0,0);
		xxinqury_prhmstr_MetaData21.setFieldDesc(2, "tt_prhmstro_receiver", 0, Parameter.PRO_CHARACTER,1,0);
		xxinqury_prhmstr_MetaData21.setFieldDesc(3, "tt_prhmstro_suppcode", 0, Parameter.PRO_CHARACTER,2,0);
		xxinqury_prhmstr_MetaData21.setFieldDesc(4, "tt_prhmstro_asnnbr", 0, Parameter.PRO_CHARACTER,3,0);
		xxinqury_prhmstr_MetaData21.setFieldDesc(5, "tt_prhmstro_shipto", 0, Parameter.PRO_CHARACTER,4,0);
		xxinqury_prhmstr_MetaData21.setFieldDesc(6, "tt_prhmstro_rcdate", 0, Parameter.PRO_CHARACTER,5,0);
		xxinqury_prhmstr_MetaData21.setFieldDesc(7, "tt_prhmstro_rcuserid", 0, Parameter.PRO_CHARACTER,6,0);
		xxinqury_prhmstr_MetaData21.setFieldDesc(8, "tt_prhmstro_prhmstroid", 0, Parameter.PRO_CHARACTER,7,0);
		xxinqury_prhmstr_DSMetaData2.addTable(xxinqury_prhmstr_MetaData21);
		xxinqury_prhmstr_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxinqury_prhmstr_MetaData22.setFieldDesc(1, "tt_erro_prhmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinqury_prhmstr_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxinqury_prhmstr_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxinqury_prhmstr_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxinqury_prhmstr_DSMetaData2.addTable(xxinqury_prhmstr_MetaData22);

	}

	static ProDataGraphMetaData xxinqury_xasnmstr_DSMetaData1;

	static ProDataObjectMetaData xxinqury_xasnmstr_MetaData11;

	static ProDataObjectMetaData xxinqury_xasnmstr_MetaData12;

	static ProDataGraphMetaData xxinqury_xasnmstr_DSMetaData2;

	static ProDataObjectMetaData xxinqury_xasnmstr_MetaData21;

	static ProDataObjectMetaData xxinqury_xasnmstr_MetaData22;


	static
	{
		xxinqury_xasnmstr_DSMetaData1 = new ProDataGraphMetaData(0, "input_xasnmstr", 1, ParameterSet.INPUT);
		xxinqury_xasnmstr_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxinqury_xasnmstr_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxinqury_xasnmstr_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxinqury_xasnmstr_DSMetaData1.addTable(xxinqury_xasnmstr_MetaData11);
		xxinqury_xasnmstr_MetaData12 = new ProDataObjectMetaData("tt_xasnmstr_in", 7, false, 0, null, null, null);
		xxinqury_xasnmstr_MetaData12.setFieldDesc(1, "tt_xasnmstri_asnnbr", 0, Parameter.PRO_CHARACTER,0,0);
		xxinqury_xasnmstr_MetaData12.setFieldDesc(2, "tt_xasnmstri_stat", 0, Parameter.PRO_CHARACTER,1,0);
		xxinqury_xasnmstr_MetaData12.setFieldDesc(3, "tt_xasnmstri_fromdate", 0, Parameter.PRO_CHARACTER,2,0);
		xxinqury_xasnmstr_MetaData12.setFieldDesc(4, "tt_xasnmstri_todate", 0, Parameter.PRO_CHARACTER,3,0);
		xxinqury_xasnmstr_MetaData12.setFieldDesc(5, "tt_xasnmstri_shipto", 0, Parameter.PRO_CHARACTER,4,0);
		xxinqury_xasnmstr_MetaData12.setFieldDesc(6, "tt_xasnmstri_yhdnbr", 0, Parameter.PRO_CHARACTER,5,0);
		xxinqury_xasnmstr_MetaData12.setFieldDesc(7, "tt_xasnmstri_partnbr", 0, Parameter.PRO_CHARACTER,6,0);
		xxinqury_xasnmstr_DSMetaData1.addTable(xxinqury_xasnmstr_MetaData12);
		xxinqury_xasnmstr_DSMetaData2 = new ProDataGraphMetaData(0, "export_xasnmstr", 2, ParameterSet.OUTPUT);
		xxinqury_xasnmstr_MetaData21 = new ProDataObjectMetaData("tt_xasnmstr_out", 7, false, 0, null, null, null);
		xxinqury_xasnmstr_MetaData21.setFieldDesc(1, "tt_xasnmstro_seq", 0, Parameter.PRO_INTEGER,0,0);
		xxinqury_xasnmstr_MetaData21.setFieldDesc(2, "tt_xasnmstro_asnnbr", 0, Parameter.PRO_CHARACTER,1,0);
		xxinqury_xasnmstr_MetaData21.setFieldDesc(3, "tt_xasnmstro_shipto", 0, Parameter.PRO_CHARACTER,2,0);
		xxinqury_xasnmstr_MetaData21.setFieldDesc(4, "tt_xasnmstro_startdt", 0, Parameter.PRO_CHARACTER,3,0);
		xxinqury_xasnmstr_MetaData21.setFieldDesc(5, "tt_xasnmstro_stat", 0, Parameter.PRO_INTEGER,4,0);
		xxinqury_xasnmstr_MetaData21.setFieldDesc(6, "tt_xasnmstro_creator", 0, Parameter.PRO_CHARACTER,5,0);
		xxinqury_xasnmstr_MetaData21.setFieldDesc(7, "tt_xasnmstro_xasnmstroid", 0, Parameter.PRO_CHARACTER,6,0);
		xxinqury_xasnmstr_DSMetaData2.addTable(xxinqury_xasnmstr_MetaData21);
		xxinqury_xasnmstr_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxinqury_xasnmstr_MetaData22.setFieldDesc(1, "tt_xasnmstro_xasnmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinqury_xasnmstr_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxinqury_xasnmstr_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxinqury_xasnmstr_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxinqury_xasnmstr_DSMetaData2.addTable(xxinqury_xasnmstr_MetaData22);

	}

	static ProDataGraphMetaData xxinqury_xpyhddet2_DSMetaData1;

	static ProDataObjectMetaData xxinqury_xpyhddet2_MetaData11;

	static ProDataGraphMetaData xxinqury_xpyhddet2_DSMetaData2;

	static ProDataObjectMetaData xxinqury_xpyhddet2_MetaData21;

	static ProDataObjectMetaData xxinqury_xpyhddet2_MetaData22;


	static
	{
		xxinqury_xpyhddet2_DSMetaData1 = new ProDataGraphMetaData(0, "input_xpyhddet", 1, ParameterSet.INPUT);
		xxinqury_xpyhddet2_MetaData11 = new ProDataObjectMetaData("tt_xpyhddet_in", 1, false, 0, null, null, null);
		xxinqury_xpyhddet2_MetaData11.setFieldDesc(1, "tt_xpyhddeti_xpyhmstroid", 0, Parameter.PRO_DECIMAL,0,0);
		xxinqury_xpyhddet2_DSMetaData1.addTable(xxinqury_xpyhddet2_MetaData11);
		xxinqury_xpyhddet2_DSMetaData2 = new ProDataGraphMetaData(0, "export_xpyhddet", 2, ParameterSet.OUTPUT);
		xxinqury_xpyhddet2_MetaData21 = new ProDataObjectMetaData("tt_xpyhddet_out", 18, false, 0, null, null, null);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(1, "tt_xpyhddeto_suppcode", 0, Parameter.PRO_CHARACTER,0,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(2, "tt_xpyhddeto_suppname", 0, Parameter.PRO_CHARACTER,1,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(3, "tt_xpyhddeto_shipfrom", 0, Parameter.PRO_CHARACTER,2,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(4, "tt_xpyhddeto_shipto", 0, Parameter.PRO_CHARACTER,3,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(5, "tt_xpyhddeto_carrier", 0, Parameter.PRO_CHARACTER,4,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(6, "tt_xpyhddeto_dock", 0, Parameter.PRO_CHARACTER,5,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(7, "tt_xpyhddeto_yhdnbr", 0, Parameter.PRO_CHARACTER,6,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(8, "tt_xpyhddeto_seq", 0, Parameter.PRO_DECIMAL,7,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(9, "tt_xpyhddeto_partnbr", 0, Parameter.PRO_CHARACTER,8,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(10, "tt_xpyhddeto_partdesc", 0, Parameter.PRO_CHARACTER,9,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(11, "tt_xpyhddeto_supppart", 0, Parameter.PRO_CHARACTER,10,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(12, "tt_xpyhddeto_uom", 0, Parameter.PRO_CHARACTER,11,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(13, "tt_xpyhddeto_spq", 0, Parameter.PRO_DECIMAL,12,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(14, "tt_xpyhddeto_toloc", 0, Parameter.PRO_CHARACTER,13,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(15, "tt_xpyhddeto_delvqty", 0, Parameter.PRO_DECIMAL,14,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(16, "tt_xpyhddeto_openqty", 0, Parameter.PRO_DECIMAL,15,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(17, "tt_xpyhddeto_xpyhmstroid", 0, Parameter.PRO_CHARACTER,16,0);
		xxinqury_xpyhddet2_MetaData21.setFieldDesc(18, "tt_xpyhddeto_xpyhddetoid", 0, Parameter.PRO_CHARACTER,17,0);
		xxinqury_xpyhddet2_DSMetaData2.addTable(xxinqury_xpyhddet2_MetaData21);
		xxinqury_xpyhddet2_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxinqury_xpyhddet2_MetaData22.setFieldDesc(1, "tt_erro_xpyhddetoid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinqury_xpyhddet2_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxinqury_xpyhddet2_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxinqury_xpyhddet2_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxinqury_xpyhddet2_DSMetaData2.addTable(xxinqury_xpyhddet2_MetaData22);

	}

	static ProDataGraphMetaData xxprint_barcode_DSMetaData1;

	static ProDataObjectMetaData xxprint_barcode_MetaData11;

	static ProDataObjectMetaData xxprint_barcode_MetaData12;

	static ProDataGraphMetaData xxprint_barcode_DSMetaData2;

	static ProDataObjectMetaData xxprint_barcode_MetaData21;

	static ProDataObjectMetaData xxprint_barcode_MetaData22;


	static
	{
		xxprint_barcode_DSMetaData1 = new ProDataGraphMetaData(0, "input_bcddet", 1, ParameterSet.INPUT);
		xxprint_barcode_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxprint_barcode_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxprint_barcode_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxprint_barcode_DSMetaData1.addTable(xxprint_barcode_MetaData11);
		xxprint_barcode_MetaData12 = new ProDataObjectMetaData("tt_bcdet_in", 7, false, 0, null, null, null);
		xxprint_barcode_MetaData12.setFieldDesc(1, "tt_bcdeti_partnbr", 0, Parameter.PRO_CHARACTER,0,0);
		xxprint_barcode_MetaData12.setFieldDesc(2, "tt_bcdeti_lots", 0, Parameter.PRO_CHARACTER,1,0);
		xxprint_barcode_MetaData12.setFieldDesc(3, "tt_bcdeti_vend_lots", 0, Parameter.PRO_CHARACTER,2,0);
		xxprint_barcode_MetaData12.setFieldDesc(4, "tt_bcdeti_qty", 0, Parameter.PRO_DECIMAL,3,0);
		xxprint_barcode_MetaData12.setFieldDesc(5, "tt_bcdeti_date", 0, Parameter.PRO_CHARACTER,4,0);
		xxprint_barcode_MetaData12.setFieldDesc(6, "tt_new_bcdeti_bcdetoid", 0, Parameter.PRO_CHARACTER,5,0);
		xxprint_barcode_MetaData12.setFieldDesc(7, "tt_bcdeti_pktype", 0, Parameter.PRO_CHARACTER,6,0);
		xxprint_barcode_DSMetaData1.addTable(xxprint_barcode_MetaData12);
		xxprint_barcode_DSMetaData2 = new ProDataGraphMetaData(0, "export_bcddet", 2, ParameterSet.OUTPUT);
		xxprint_barcode_MetaData21 = new ProDataObjectMetaData("tt_bcdet_out", 11, false, 0, null, null, null);
		xxprint_barcode_MetaData21.setFieldDesc(1, "tt_bcdeto_date", 0, Parameter.PRO_CHARACTER,0,0);
		xxprint_barcode_MetaData21.setFieldDesc(2, "tt_bcdeto_partnbr", 0, Parameter.PRO_CHARACTER,1,0);
		xxprint_barcode_MetaData21.setFieldDesc(3, "tt_bcdeto_partdesc", 0, Parameter.PRO_CHARACTER,2,0);
		xxprint_barcode_MetaData21.setFieldDesc(4, "tt_bcdeto_lots", 0, Parameter.PRO_CHARACTER,3,0);
		xxprint_barcode_MetaData21.setFieldDesc(5, "tt_bcdeto_qty", 0, Parameter.PRO_DECIMAL,4,0);
		xxprint_barcode_MetaData21.setFieldDesc(6, "tt_bcdeto_bcinfo1", 0, Parameter.PRO_CHARACTER,5,0);
		xxprint_barcode_MetaData21.setFieldDesc(7, "tt_bcdeto_suppname", 0, Parameter.PRO_CHARACTER,6,0);
		xxprint_barcode_MetaData21.setFieldDesc(8, "tt_bcdeto_bcinfo2", 0, Parameter.PRO_CHARACTER,7,0);
		xxprint_barcode_MetaData21.setFieldDesc(9, "tt_bcdeto_serial", 0, Parameter.PRO_CHARACTER,8,0);
		xxprint_barcode_MetaData21.setFieldDesc(10, "tt_bcdeto_bcdetoid", 0, Parameter.PRO_CHARACTER,9,0);
		xxprint_barcode_MetaData21.setFieldDesc(11, "tt_bcdeto_bcnon", 0, Parameter.PRO_CHARACTER,10,0);
		xxprint_barcode_DSMetaData2.addTable(xxprint_barcode_MetaData21);
		xxprint_barcode_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxprint_barcode_MetaData22.setFieldDesc(1, "tt_erro_bcdetoid", 0, Parameter.PRO_CHARACTER,0,0);
		xxprint_barcode_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxprint_barcode_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxprint_barcode_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxprint_barcode_DSMetaData2.addTable(xxprint_barcode_MetaData22);

	}

	static ProDataGraphMetaData xxupdate_xprcmstr_DSMetaData1;

	static ProDataObjectMetaData xxupdate_xprcmstr_MetaData11;

	static ProDataGraphMetaData xxupdate_xprcmstr_DSMetaData2;

	static ProDataObjectMetaData xxupdate_xprcmstr_MetaData21;


	static
	{
		xxupdate_xprcmstr_DSMetaData1 = new ProDataGraphMetaData(0, "input_xprc", 1, ParameterSet.INPUT);
		xxupdate_xprcmstr_MetaData11 = new ProDataObjectMetaData("tt_xprcmstr_in", 13, false, 0, null, null, null);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(1, "tt_xprcdeti_xprcmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(2, "tt_xprcmstri_qty", 0, Parameter.PRO_INTEGER,1,0);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(3, "tt_xprcmstri_taxamt", 0, Parameter.PRO_DECIMAL,2,0);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(4, "tt_xprcmstri_invdate", 0, Parameter.PRO_CHARACTER,3,0);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(5, "tt_xprcmstri_notaxamt", 0, Parameter.PRO_DECIMAL,4,0);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(6, "tt_xprcmstri_invnbr", 0, Parameter.PRO_CHARACTER,5,0);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(7, "tt_xprcmstri_rmk", 0, Parameter.PRO_CHARACTER,6,0);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(8, "tt_xprcmstri_stat", 0, Parameter.PRO_CHARACTER,7,0);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(9, "tt_xprcmstri_indexinvnbr", 0, Parameter.PRO_CHARACTER,8,0);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(10, "tt_xprcmstri_type", 0, Parameter.PRO_CHARACTER,9,0);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(11, "tt_xprcmstri_creator", 0, Parameter.PRO_CHARACTER,10,0);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(12, "tt_xprcmstri_disamt", 0, Parameter.PRO_DECIMAL,11,0);
		xxupdate_xprcmstr_MetaData11.setFieldDesc(13, "tt_xprcmstri_claimamt", 0, Parameter.PRO_DECIMAL,11,0);
		
		xxupdate_xprcmstr_DSMetaData1.addTable(xxupdate_xprcmstr_MetaData11);
		xxupdate_xprcmstr_DSMetaData2 = new ProDataGraphMetaData(0, "export_xprc", 2, ParameterSet.OUTPUT);
		xxupdate_xprcmstr_MetaData21 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxupdate_xprcmstr_MetaData21.setFieldDesc(1, "tt_erro_xprcmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxupdate_xprcmstr_MetaData21.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxupdate_xprcmstr_MetaData21.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxupdate_xprcmstr_MetaData21.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxupdate_xprcmstr_DSMetaData2.addTable(xxupdate_xprcmstr_MetaData21);

	}

	static ProDataGraphMetaData xxupdate_xpyhmstr_DSMetaData1;

	static ProDataObjectMetaData xxupdate_xpyhmstr_MetaData11;

	static ProDataGraphMetaData xxupdate_xpyhmstr_DSMetaData2;

	static ProDataObjectMetaData xxupdate_xpyhmstr_MetaData21;

	
	
	static
	{
		xxupdate_xpyhmstr_DSMetaData1 = new ProDataGraphMetaData(0, "input_xpyhmstr", 1, ParameterSet.INPUT);
		xxupdate_xpyhmstr_MetaData11 = new ProDataObjectMetaData("tt_xpyhmstr_in", 3, false, 0, null, null, null);
		xxupdate_xpyhmstr_MetaData11.setFieldDesc(1, "tt_xpyhmstri_xpyhmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxupdate_xpyhmstr_MetaData11.setFieldDesc(2, "tt_old_xpyhmstri_stat", 0, Parameter.PRO_CHARACTER,1,0);
		xxupdate_xpyhmstr_MetaData11.setFieldDesc(3, "tt_new_xpyhmstri_stat", 0, Parameter.PRO_CHARACTER,2,0);
		xxupdate_xpyhmstr_DSMetaData1.addTable(xxupdate_xpyhmstr_MetaData11);
		xxupdate_xpyhmstr_DSMetaData2 = new ProDataGraphMetaData(0, "export_xpyhmstr", 2, ParameterSet.OUTPUT);
		xxupdate_xpyhmstr_MetaData21 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxupdate_xpyhmstr_MetaData21.setFieldDesc(1, "tt_erro_errid", 0, Parameter.PRO_INTEGER,0,0);
		xxupdate_xpyhmstr_MetaData21.setFieldDesc(2, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,1,0);
		xxupdate_xpyhmstr_MetaData21.setFieldDesc(3, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,2,0);
		xxupdate_xpyhmstr_MetaData21.setFieldDesc(4, "tt_erro_xpyhmstroid", 0, Parameter.PRO_CHARACTER,3,0);
		xxupdate_xpyhmstr_DSMetaData2.addTable(xxupdate_xpyhmstr_MetaData21);

	}

	static ProDataGraphMetaData xxview_xasndet_DSMetaData1;

	static ProDataObjectMetaData xxview_xasndet_MetaData11;

	static ProDataGraphMetaData xxview_xasndet_DSMetaData2;

	static ProDataObjectMetaData xxview_xasndet_MetaData21;

	static ProDataObjectMetaData xxview_xasndet_MetaData22;


	static
	{
		xxview_xasndet_DSMetaData1 = new ProDataGraphMetaData(0, "input_xasndet", 1, ParameterSet.INPUT);
		xxview_xasndet_MetaData11 = new ProDataObjectMetaData("tt_xasndet_in", 1, false, 0, null, null, null);
		xxview_xasndet_MetaData11.setFieldDesc(1, "tt_xasndeti_xasnmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxview_xasndet_DSMetaData1.addTable(xxview_xasndet_MetaData11);
		xxview_xasndet_DSMetaData2 = new ProDataGraphMetaData(0, "export_xasndet", 2, ParameterSet.OUTPUT);
		xxview_xasndet_MetaData21 = new ProDataObjectMetaData("tt_xasndet_out", 23, false, 0, null, null, null);
		xxview_xasndet_MetaData21.setFieldDesc(1, "tt_xasndeto_seq", 0, Parameter.PRO_INTEGER,0,0);
		xxview_xasndet_MetaData21.setFieldDesc(2, "tt_xasndeto_asnnbr", 0, Parameter.PRO_CHARACTER,1,0);
		xxview_xasndet_MetaData21.setFieldDesc(3, "tt_xasndeto_shipto", 0, Parameter.PRO_CHARACTER,2,0);
		xxview_xasndet_MetaData21.setFieldDesc(4, "tt_xasndeto_startdt", 0, Parameter.PRO_CHARACTER,3,0);
		xxview_xasndet_MetaData21.setFieldDesc(5, "tt_xasndeto_stat", 0, Parameter.PRO_CHARACTER,4,0);
		xxview_xasndet_MetaData21.setFieldDesc(6, "tt_xasndeto_creator", 0, Parameter.PRO_CHARACTER,5,0);
		xxview_xasndet_MetaData21.setFieldDesc(7, "tt_xasndeto_partnbr", 0, Parameter.PRO_CHARACTER,6,0);
		xxview_xasndet_MetaData21.setFieldDesc(8, "tt_xasndeto_partdesc", 0, Parameter.PRO_CHARACTER,7,0);
		xxview_xasndet_MetaData21.setFieldDesc(9, "tt_xasndeto_supppart", 0, Parameter.PRO_CHARACTER,8,0);
		xxview_xasndet_MetaData21.setFieldDesc(10, "tt_xasndeto_uom", 0, Parameter.PRO_CHARACTER,9,0);
		xxview_xasndet_MetaData21.setFieldDesc(11, "tt_xasndeto_spq", 0, Parameter.PRO_DECIMAL,10,0);
		xxview_xasndet_MetaData21.setFieldDesc(12, "tt_xasndeto_asnqty", 0, Parameter.PRO_DECIMAL,11,0);
		xxview_xasndet_MetaData21.setFieldDesc(13, "tt_xasndeto_delvqty", 0, Parameter.PRO_DECIMAL,12,0);
		xxview_xasndet_MetaData21.setFieldDesc(14, "tt_xasndeto_xasndetoid", 0, Parameter.PRO_CHARACTER,13,0);
		xxview_xasndet_MetaData21.setFieldDesc(15, "tt_xasndeto_yhdnbr", 0, Parameter.PRO_CHARACTER,14,0);
		xxview_xasndet_MetaData21.setFieldDesc(16, "tt_xasndeto_vend", 0, Parameter.PRO_CHARACTER,15,0);
		xxview_xasndet_MetaData21.setFieldDesc(17, "tt_xasndeto_vendname", 0, Parameter.PRO_CHARACTER,16,0);
		xxview_xasndet_MetaData21.setFieldDesc(18, "tt_xasndeto_vendaddr", 0, Parameter.PRO_CHARACTER,17,0);
		xxview_xasndet_MetaData21.setFieldDesc(19, "tt_xasndeto_vendcontact", 0, Parameter.PRO_CHARACTER,18,0);
		xxview_xasndet_MetaData21.setFieldDesc(20, "tt_xasndeto_vendphone", 0, Parameter.PRO_CHARACTER,19,0);
		xxview_xasndet_MetaData21.setFieldDesc(21, "tt_xasndeto_vendtax", 0, Parameter.PRO_CHARACTER,20,0);
		xxview_xasndet_MetaData21.setFieldDesc(22, "tt_xasndeto_shipname", 0, Parameter.PRO_CHARACTER,21,0);
		xxview_xasndet_MetaData21.setFieldDesc(23, "tt_xasndeto_shipaddr", 0, Parameter.PRO_CHARACTER,22,0);
		
		xxview_xasndet_DSMetaData2.addTable(xxview_xasndet_MetaData21);
		xxview_xasndet_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxview_xasndet_MetaData22.setFieldDesc(1, "tt_xasndeto_xasndetoid", 0, Parameter.PRO_CHARACTER,0,0);
		xxview_xasndet_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxview_xasndet_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxview_xasndet_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxview_xasndet_DSMetaData2.addTable(xxview_xasndet_MetaData22);

	}

	static ProDataGraphMetaData xxview_xpyhddet_DSMetaData1;

	static ProDataObjectMetaData xxview_xpyhddet_MetaData11;

	static ProDataGraphMetaData xxview_xpyhddet_DSMetaData2;

	static ProDataObjectMetaData xxview_xpyhddet_MetaData21;

	static ProDataObjectMetaData xxview_xpyhddet_MetaData22;


	static
	{
		xxview_xpyhddet_DSMetaData1 = new ProDataGraphMetaData(0, "input_xpyhddet", 1, ParameterSet.INPUT);
		xxview_xpyhddet_MetaData11 = new ProDataObjectMetaData("tt_xpyhddet_in", 2, false, 0, null, null, null);
		xxview_xpyhddet_MetaData11.setFieldDesc(1, "tt_xpyhddeti_xpyhmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxview_xpyhddet_MetaData11.setFieldDesc(2, "tt_xpyhddeti_type", 0, Parameter.PRO_CHARACTER,1,0);
		xxview_xpyhddet_DSMetaData1.addTable(xxview_xpyhddet_MetaData11);
		xxview_xpyhddet_DSMetaData2 = new ProDataGraphMetaData(0, "export_xpyhddet", 2, ParameterSet.OUTPUT);
		xxview_xpyhddet_MetaData21 = new ProDataObjectMetaData("tt_xpyhddet_out", 32, false, 0, null, null, null);
		xxview_xpyhddet_MetaData21.setFieldDesc(1, "tt_xpyhddeto_yhdnbr", 0, Parameter.PRO_CHARACTER,0,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(2, "tt_xpyhddeto_startdt", 0, Parameter.PRO_CHARACTER,1,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(3, "tt_xpyhddeto_suppcode", 0, Parameter.PRO_CHARACTER,2,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(4, "tt_xpyhddeto_shipfrom", 0, Parameter.PRO_CHARACTER,3,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(5, "tt_xpyhddeto_priority", 0, Parameter.PRO_CHARACTER,4,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(6, "tt_xpyhddeto_currcy", 0, Parameter.PRO_CHARACTER,5,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(7, "tt_xpyhddeto_receptdt", 0, Parameter.PRO_CHARACTER,6,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(8, "tt_xpyhddeto_recepttm", 0, Parameter.PRO_CHARACTER,7,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(9, "tt_xpyhddeto_shipto", 0, Parameter.PRO_CHARACTER,8,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(10, "tt_xpyhddeto_stat", 0, Parameter.PRO_CHARACTER,9,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(11, "tt_xpyhddeto_remark", 0, Parameter.PRO_CHARACTER,10,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(12, "tt_xpyhddeto_seq", 0, Parameter.PRO_CHARACTER,11,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(13, "tt_xpyhddeto_partnbr", 0, Parameter.PRO_CHARACTER,12,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(14, "tt_xpyhddeto_partdesc", 0, Parameter.PRO_CHARACTER,13,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(15, "tt_xpyhddeto_supppart", 0, Parameter.PRO_CHARACTER,14,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(16, "tt_xpyhddeto_uom", 0, Parameter.PRO_CHARACTER,15,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(17, "tt_xpyhddeto_innnerqty", 0, Parameter.PRO_DECIMAL,16,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(18, "tt_xpyhddeto_externalqty", 0, Parameter.PRO_DECIMAL,17,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(19, "tt_xpyhddeto_reqqty", 0, Parameter.PRO_DECIMAL,18,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(20, "tt_xpyhddeto_ordqty", 0, Parameter.PRO_DECIMAL,19,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(21, "tt_xpyhddeto_shipedqty", 0, Parameter.PRO_DECIMAL,20,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(22, "tt_xpyhddeto_delvqty", 0, Parameter.PRO_DECIMAL,21,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(23, "tt_xpyhddeto_xpyhmstroid", 0, Parameter.PRO_CHARACTER,22,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(24, "tt_xpyhddeto_xpyhddetoid", 0, Parameter.PRO_CHARACTER,23,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(25, "tt_xpyhddeto_spq", 0, Parameter.PRO_DECIMAL,24,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(26, "tt_xpyhddeto_pkqty", 0, Parameter.PRO_INTEGER,25,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(27, "tt_xpyhddeto_shipto_en", 0, Parameter.PRO_CHARACTER,26,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(28, "tt_xpyhddeto_suppname", 0, Parameter.PRO_CHARACTER,27,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(29, "tt_xpyhddeto_suppaddr", 0, Parameter.PRO_CHARACTER,28,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(30, "tt_xpyhddeto_suppcontant", 0, Parameter.PRO_CHARACTER,29,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(31, "tt_xpyhddeto_supptel", 0, Parameter.PRO_CHARACTER,30,0);
		xxview_xpyhddet_MetaData21.setFieldDesc(32, "tt_xpyhddeto_suppfax", 0, Parameter.PRO_CHARACTER,31,0);
		xxview_xpyhddet_DSMetaData2.addTable(xxview_xpyhddet_MetaData21);
		xxview_xpyhddet_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxview_xpyhddet_MetaData22.setFieldDesc(1, "tt_erro_xpyhddetoid", 0, Parameter.PRO_CHARACTER,0,0);
		xxview_xpyhddet_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxview_xpyhddet_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxview_xpyhddet_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxview_xpyhddet_DSMetaData2.addTable(xxview_xpyhddet_MetaData22);

	}
	
	
	static ProDataGraphMetaData xxview_forecast_DSMetaData1;

	static ProDataObjectMetaData xxview_forecast_MetaData11;
	
	static ProDataObjectMetaData xxview_forecast_MetaData12;

	static ProDataGraphMetaData xxview_forecast_DSMetaData2;

	static ProDataObjectMetaData xxview_forecast_MetaData21;

	static ProDataObjectMetaData xxview_forecast_MetaData22;


	static
	{
		xxview_forecast_DSMetaData1 = new ProDataGraphMetaData(0, "input_scpfcast", 1, ParameterSet.INPUT);
	
		xxview_forecast_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxview_forecast_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxview_forecast_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxview_forecast_DSMetaData1.addTable(xxview_forecast_MetaData11);
		xxview_forecast_MetaData12 = new ProDataObjectMetaData("tt_forecast_in", 5, false, 0, null, null, null);
		xxview_forecast_MetaData12.setFieldDesc(1, "tt_forecast_sp", 0, Parameter.PRO_CHARACTER,0,0);
		xxview_forecast_MetaData12.setFieldDesc(2, "tt_forecast_shipto", 0, Parameter.PRO_CHARACTER,1,0);
		xxview_forecast_MetaData12.setFieldDesc(3, "tt_forecast_fcastdt", 0, Parameter.PRO_CHARACTER,2,0);
		xxview_forecast_MetaData12.setFieldDesc(4, "tt_forecast_partnbr", 0, Parameter.PRO_CHARACTER,3,0);
		xxview_forecast_MetaData12.setFieldDesc(5, "tt_forecast_fenddt", 0, Parameter.PRO_CHARACTER,4,0);
		xxview_forecast_DSMetaData1.addTable(xxview_forecast_MetaData12);
		xxview_forecast_DSMetaData2 = new ProDataGraphMetaData(0, "export_scpfcast", 2, ParameterSet.OUTPUT);
		xxview_forecast_MetaData21 = new ProDataObjectMetaData("tt_forecast_out", 12, false, 0, null, null, null);
		xxview_forecast_MetaData21.setFieldDesc(1, "tt_forecast_seq", 0, Parameter.PRO_CHARACTER,0,0);
		xxview_forecast_MetaData21.setFieldDesc(2, "tt_forecast_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxview_forecast_MetaData21.setFieldDesc(3, "tt_forecast_shipto", 0, Parameter.PRO_CHARACTER,2,0);
		xxview_forecast_MetaData21.setFieldDesc(4, "tt_forecast_partnbr", 0, Parameter.PRO_CHARACTER,3,0);
		xxview_forecast_MetaData21.setFieldDesc(5, "tt_forecast_partdesc", 0, Parameter.PRO_CHARACTER,4,0);
		xxview_forecast_MetaData21.setFieldDesc(6, "tt_forecast_supppart", 0, Parameter.PRO_CHARACTER,5,0);
		xxview_forecast_MetaData21.setFieldDesc(7, "tt_forecast_reqdt", 0, Parameter.PRO_CHARACTER,6,0);
		xxview_forecast_MetaData21.setFieldDesc(8, "tt_forecast_currcy", 0, Parameter.PRO_CHARACTER,7,0);
		xxview_forecast_MetaData21.setFieldDesc(9, "tt_forecast_uom", 0, Parameter.PRO_CHARACTER,8,0);
		xxview_forecast_MetaData21.setFieldDesc(10, "tt_forecast_inerpk", 0, Parameter.PRO_DECIMAL,9,0);
		xxview_forecast_MetaData21.setFieldDesc(11, "tt_forecast_extpk", 0, Parameter.PRO_DECIMAL,10,0);
		xxview_forecast_MetaData21.setFieldDesc(12, "tt_forecast_fcastqty", 0, Parameter.PRO_DECIMAL,11,0);
		xxview_forecast_DSMetaData2.addTable(xxview_forecast_MetaData21);
		xxview_forecast_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxview_forecast_MetaData22.setFieldDesc(1, "tt_erro_xpyhddetoid", 0, Parameter.PRO_CHARACTER,0,0);
		xxview_forecast_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxview_forecast_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxview_forecast_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxview_forecast_DSMetaData2.addTable(xxview_forecast_MetaData22);

	}
	
	
	static ProDataGraphMetaData xxinquiry_claimdet_DSMetaData1;

	static ProDataObjectMetaData xxinquiry_claimdet_MetaData11;

	static ProDataGraphMetaData xxinquiry_claimdet_DSMetaData2;

	static ProDataObjectMetaData xxinquiry_claimdet_MetaData21;

	static ProDataObjectMetaData xxinquiry_claimdet_MetaData22;


	static
	{
		xxinquiry_claimdet_DSMetaData1 = new ProDataGraphMetaData(0, "input_xprcd", 1, ParameterSet.INPUT);
		xxinquiry_claimdet_MetaData11 = new ProDataObjectMetaData("tt_claimdet_in", 1, false, 0, null, null, null);
		xxinquiry_claimdet_MetaData11.setFieldDesc(1, "tt_claimdeti_xprcmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_claimdet_DSMetaData1.addTable(xxinquiry_claimdet_MetaData11);
		xxinquiry_claimdet_DSMetaData2 = new ProDataGraphMetaData(0, "export_xprcd", 2, ParameterSet.OUTPUT);
		xxinquiry_claimdet_MetaData21 = new ProDataObjectMetaData("tt_claimdet_out", 18, false, 0, null, null, null);
		xxinquiry_claimdet_MetaData21.setFieldDesc(1, "tt_claimdeto_voucher", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(2, "tt_claimdeto_partnbr", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(3, "tt_claimdeto_receiver", 0, Parameter.PRO_CHARACTER,2,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(4, "tt_claimdeto_seq", 0, Parameter.PRO_INTEGER,3,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(5, "tt_claimdeto_poprice", 0, Parameter.PRO_DECIMAL,4,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(6, "tt_claimdeto_uom", 0, Parameter.PRO_CHARACTER,5,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(7, "tt_claimdeto_invprice", 0, Parameter.PRO_DECIMAL,6,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(8, "tt_claimdeto_invamt", 0, Parameter.PRO_DECIMAL,7,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(9, "tt_claimdeto_partdesc", 0, Parameter.PRO_CHARACTER,8,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(10, "tt_claimdeto_rcdate", 0, Parameter.PRO_CHARACTER,9,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(11, "tt_claimdeto_invdate", 0, Parameter.PRO_CHARACTER,10,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(12, "tt_claimdeto_totalamt", 0, Parameter.PRO_DECIMAL,11,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(13, "tt_claimdeto_rmk", 0, Parameter.PRO_CHARACTER,12,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(14, "tt_claimdeto_suppcode", 0, Parameter.PRO_CHARACTER,13,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(15, "tt_claimdeto_stat", 0, Parameter.PRO_CHARACTER,14,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(16, "tt_claimdeto_xprcmstroid", 0, Parameter.PRO_CHARACTER,15,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(17, "tt_claimdeto_rcqty", 0, Parameter.PRO_DECIMAL,16,0);
		xxinquiry_claimdet_MetaData21.setFieldDesc(18, "tt_claimdeto_billno", 0, Parameter.PRO_CHARACTER,17,0);
		xxinquiry_claimdet_DSMetaData2.addTable(xxinquiry_claimdet_MetaData21);
		xxinquiry_claimdet_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxinquiry_claimdet_MetaData22.setFieldDesc(1, "tt_erro_xprcdetoid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_claimdet_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxinquiry_claimdet_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxinquiry_claimdet_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_claimdet_DSMetaData2.addTable(xxinquiry_claimdet_MetaData22);

	}
	
	static ProDataGraphMetaData xxinquiry_cinvoice_DSMetaData1;

	static ProDataObjectMetaData xxinquiry_cinvoice_MetaData11;

	static ProDataObjectMetaData xxinquiry_cinvoice_MetaData12;

	static ProDataGraphMetaData xxinquiry_cinvoice_DSMetaData2;

	static ProDataObjectMetaData xxinquiry_cinvoice_MetaData21;

	static ProDataObjectMetaData xxinquiry_cinvoice_MetaData22;


	static
	{
		xxinquiry_cinvoice_DSMetaData1 = new ProDataGraphMetaData(0, "input_xprc", 1, ParameterSet.INPUT);
		xxinquiry_cinvoice_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxinquiry_cinvoice_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_cinvoice_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_cinvoice_DSMetaData1.addTable(xxinquiry_cinvoice_MetaData11);
		xxinquiry_cinvoice_MetaData12 = new ProDataObjectMetaData("tt_cinvoice_in", 8, false, 0, null, null, null);
		xxinquiry_cinvoice_MetaData12.setFieldDesc(1, "tt_cinvoice_sp", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_cinvoice_MetaData12.setFieldDesc(2, "tt_cinvoice_fromdate", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_cinvoice_MetaData12.setFieldDesc(3, "tt_cinvoice_todate", 0, Parameter.PRO_CHARACTER,2,0);
		xxinquiry_cinvoice_MetaData12.setFieldDesc(4, "tt_cinvoice_rf", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_cinvoice_MetaData12.setFieldDesc(5, "tt_cinvoice_curr", 0, Parameter.PRO_CHARACTER,4,0);
		xxinquiry_cinvoice_MetaData12.setFieldDesc(6, "tt_cinvoice_type", 0, Parameter.PRO_CHARACTER,5,0);
		xxinquiry_cinvoice_MetaData12.setFieldDesc(7, "tt_cinvoice_term", 0, Parameter.PRO_CHARACTER,6,0);
		xxinquiry_cinvoice_MetaData12.setFieldDesc(8, "tt_cinvoice_duedate", 0, Parameter.PRO_CHARACTER,7,0);
		xxinquiry_cinvoice_DSMetaData1.addTable(xxinquiry_cinvoice_MetaData12);
		xxinquiry_cinvoice_DSMetaData2 = new ProDataGraphMetaData(0, "export_xprc", 2, ParameterSet.OUTPUT);
		xxinquiry_cinvoice_MetaData21 = new ProDataObjectMetaData("tt_cinvoice_out", 15, false, 0, null, null, null);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(1, "tt_cinvoiceout_sp", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(2, "tt_cinvoiceout_invdate", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(3, "tt_cinvoiceout_br", 0, Parameter.PRO_CHARACTER,2,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(4, "tt_cinvoiceout_rf", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(5, "tt_cinvoiceout_duedate", 0, Parameter.PRO_CHARACTER,4,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(6, "tt_cinvoiceout_tb", 0, Parameter.PRO_DECIMAL,5,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(7, "tt_cinvoiceout_curr", 0, Parameter.PRO_CHARACTER,6,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(8, "tt_cinvoiceout_tbcr", 0, Parameter.PRO_DECIMAL,7,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(9, "tt_cinvoiceout_tbdr", 0, Parameter.PRO_DECIMAL,8,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(10, "tt_cinvoiceout_type", 0, Parameter.PRO_CHARACTER,9,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(11, "tt_cinvoiceout_hold", 0, Parameter.PRO_DECIMAL,10,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(12, "tt_cinvoiceout_brname", 0, Parameter.PRO_CHARACTER,11,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(13, "tt_cinvoiceout_term", 0, Parameter.PRO_CHARACTER,12,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(14, "tt_cinvoiceout_id", 0, Parameter.PRO_INTEGER,13,0);
		xxinquiry_cinvoice_MetaData21.setFieldDesc(15, "tt_cinvoiceout_desc", 0, Parameter.PRO_CHARACTER,14,0);
		xxinquiry_cinvoice_DSMetaData2.addTable(xxinquiry_cinvoice_MetaData21);
		xxinquiry_cinvoice_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxinquiry_cinvoice_MetaData22.setFieldDesc(1, "tt_erro_xprcmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_cinvoice_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxinquiry_cinvoice_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxinquiry_cinvoice_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_cinvoice_DSMetaData2.addTable(xxinquiry_cinvoice_MetaData22);

	}

	static ProDataGraphMetaData xxinquiry_payment_DSMetaData1;

	static ProDataObjectMetaData xxinquiry_payment_MetaData11;

	static ProDataObjectMetaData xxinquiry_payment_MetaData12;

	static ProDataGraphMetaData xxinquiry_payment_DSMetaData2;

	static ProDataObjectMetaData xxinquiry_payment_MetaData21;

	static ProDataObjectMetaData xxinquiry_payment_MetaData22;


	static
	{
		xxinquiry_payment_DSMetaData1 = new ProDataGraphMetaData(0, "input_xprc", 1, ParameterSet.INPUT);
		xxinquiry_payment_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxinquiry_payment_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_payment_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_payment_DSMetaData1.addTable(xxinquiry_payment_MetaData11);
		xxinquiry_payment_MetaData12 = new ProDataObjectMetaData("tt_payment_in", 8, false, 0, null, null, null);
		xxinquiry_payment_MetaData12.setFieldDesc(1, "tt_payment_payrf", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_payment_MetaData12.setFieldDesc(2, "tt_payment_rf", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_payment_MetaData12.setFieldDesc(3, "tt_payment_curr", 0, Parameter.PRO_CHARACTER,2,0);
		xxinquiry_payment_MetaData12.setFieldDesc(4, "tt_payment_status", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_payment_MetaData12.setFieldDesc(5, "tt_payment_entity", 0, Parameter.PRO_CHARACTER,4,0);
		xxinquiry_payment_MetaData12.setFieldDesc(6, "tt_paymentout_sp", 0, Parameter.PRO_CHARACTER,5,0);
		xxinquiry_payment_MetaData12.setFieldDesc(7, "tt_payment_fromdate", 0, Parameter.PRO_CHARACTER,6,0);
		xxinquiry_payment_MetaData12.setFieldDesc(8, "tt_payment_todate", 0, Parameter.PRO_CHARACTER,7,0);
		
		xxinquiry_payment_DSMetaData1.addTable(xxinquiry_payment_MetaData12);
		xxinquiry_payment_DSMetaData2 = new ProDataGraphMetaData(0, "export_xprc", 2, ParameterSet.OUTPUT);
		xxinquiry_payment_MetaData21 = new ProDataObjectMetaData("tt_payment_out", 13, false, 0, null, null, null);
		xxinquiry_payment_MetaData21.setFieldDesc(1, "tt_paymentout_payrf", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_payment_MetaData21.setFieldDesc(2, "tt_paymentout_rf", 0, Parameter.PRO_CHARACTER,1,0);
		xxinquiry_payment_MetaData21.setFieldDesc(3, "tt_paymentout_date", 0, Parameter.PRO_CHARACTER,2,0);
		xxinquiry_payment_MetaData21.setFieldDesc(4, "tt_paymentout_orgTC", 0, Parameter.PRO_DECIMAL,3,0);
		xxinquiry_payment_MetaData21.setFieldDesc(5, "tt_paymentout_curr", 0, Parameter.PRO_CHARACTER,4,0);
		xxinquiry_payment_MetaData21.setFieldDesc(6, "tt_paymentout_invno", 0, Parameter.PRO_CHARACTER,5,0);
		xxinquiry_payment_MetaData21.setFieldDesc(7, "tt_paymentout_status", 0, Parameter.PRO_CHARACTER,6,0);
		xxinquiry_payment_MetaData21.setFieldDesc(8, "tt_paymentout_TC", 0, Parameter.PRO_DECIMAL,7,0);
		xxinquiry_payment_MetaData21.setFieldDesc(9, "tt_paymentout_openTC", 0, Parameter.PRO_DECIMAL,8,0);
		xxinquiry_payment_MetaData21.setFieldDesc(10, "tt_paymentout_entity", 0, Parameter.PRO_CHARACTER,9,0);
		xxinquiry_payment_MetaData21.setFieldDesc(11, "tt_paymentout_sp", 0, Parameter.PRO_CHARACTER,10,0);
		xxinquiry_payment_MetaData21.setFieldDesc(12, "tt_paymentout_id", 0, Parameter.PRO_INTEGER,11,0);
		xxinquiry_payment_MetaData21.setFieldDesc(13, "tt_paymentout_type", 0, Parameter.PRO_CHARACTER,12,0);
		xxinquiry_payment_DSMetaData2.addTable(xxinquiry_payment_MetaData21);
		xxinquiry_payment_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxinquiry_payment_MetaData22.setFieldDesc(1, "tt_erro_xprcmstroid", 0, Parameter.PRO_CHARACTER,0,0);
		xxinquiry_payment_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxinquiry_payment_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxinquiry_payment_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxinquiry_payment_DSMetaData2.addTable(xxinquiry_payment_MetaData22);

	}


    //---- Constructor

    public static ProDataGraphMetaData getXxcreate_xasndet_DSMetaData1() {
		return xxcreate_xasndet_DSMetaData1;
	}


	public static void setXxcreate_xasndet_DSMetaData1(ProDataGraphMetaData xxcreate_xasndet_DSMetaData1) {
		YFKSSSCPImpl.xxcreate_xasndet_DSMetaData1 = xxcreate_xasndet_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxcreate_xasndet_MetaData11() {
		return xxcreate_xasndet_MetaData11;
	}


	public static void setXxcreate_xasndet_MetaData11(ProDataObjectMetaData xxcreate_xasndet_MetaData11) {
		YFKSSSCPImpl.xxcreate_xasndet_MetaData11 = xxcreate_xasndet_MetaData11;
	}


	public static ProDataGraphMetaData getXxcreate_xasndet_DSMetaData2() {
		return xxcreate_xasndet_DSMetaData2;
	}


	public static void setXxcreate_xasndet_DSMetaData2(ProDataGraphMetaData xxcreate_xasndet_DSMetaData2) {
		YFKSSSCPImpl.xxcreate_xasndet_DSMetaData2 = xxcreate_xasndet_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxcreate_xasndet_MetaData21() {
		return xxcreate_xasndet_MetaData21;
	}


	public static void setXxcreate_xasndet_MetaData21(ProDataObjectMetaData xxcreate_xasndet_MetaData21) {
		YFKSSSCPImpl.xxcreate_xasndet_MetaData21 = xxcreate_xasndet_MetaData21;
	}


	public static ProDataObjectMetaData getXxcreate_xasndet_MetaData22() {
		return xxcreate_xasndet_MetaData22;
	}


	public static void setXxcreate_xasndet_MetaData22(ProDataObjectMetaData xxcreate_xasndet_MetaData22) {
		YFKSSSCPImpl.xxcreate_xasndet_MetaData22 = xxcreate_xasndet_MetaData22;
	}


	public static ProDataGraphMetaData getXxexport_xasndet_DSMetaData1() {
		return xxexport_xasndet_DSMetaData1;
	}


	public static void setXxexport_xasndet_DSMetaData1(ProDataGraphMetaData xxexport_xasndet_DSMetaData1) {
		YFKSSSCPImpl.xxexport_xasndet_DSMetaData1 = xxexport_xasndet_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxexport_xasndet_MetaData11() {
		return xxexport_xasndet_MetaData11;
	}


	public static void setXxexport_xasndet_MetaData11(ProDataObjectMetaData xxexport_xasndet_MetaData11) {
		YFKSSSCPImpl.xxexport_xasndet_MetaData11 = xxexport_xasndet_MetaData11;
	}


	public static ProDataObjectMetaData getXxexport_xasndet_MetaData12() {
		return xxexport_xasndet_MetaData12;
	}


	public static void setXxexport_xasndet_MetaData12(ProDataObjectMetaData xxexport_xasndet_MetaData12) {
		YFKSSSCPImpl.xxexport_xasndet_MetaData12 = xxexport_xasndet_MetaData12;
	}


	public static ProDataGraphMetaData getXxexport_xasndet_DSMetaData2() {
		return xxexport_xasndet_DSMetaData2;
	}


	public static void setXxexport_xasndet_DSMetaData2(ProDataGraphMetaData xxexport_xasndet_DSMetaData2) {
		YFKSSSCPImpl.xxexport_xasndet_DSMetaData2 = xxexport_xasndet_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxexport_xasndet_MetaData21() {
		return xxexport_xasndet_MetaData21;
	}


	public static void setXxexport_xasndet_MetaData21(ProDataObjectMetaData xxexport_xasndet_MetaData21) {
		YFKSSSCPImpl.xxexport_xasndet_MetaData21 = xxexport_xasndet_MetaData21;
	}


	public static ProDataObjectMetaData getXxexport_xasndet_MetaData22() {
		return xxexport_xasndet_MetaData22;
	}


	public static void setXxexport_xasndet_MetaData22(ProDataObjectMetaData xxexport_xasndet_MetaData22) {
		YFKSSSCPImpl.xxexport_xasndet_MetaData22 = xxexport_xasndet_MetaData22;
	}


	public static ProDataGraphMetaData getXxexport_xpyhddet_DSMetaData1() {
		return xxexport_xpyhddet_DSMetaData1;
	}


	public static void setXxexport_xpyhddet_DSMetaData1(ProDataGraphMetaData xxexport_xpyhddet_DSMetaData1) {
		YFKSSSCPImpl.xxexport_xpyhddet_DSMetaData1 = xxexport_xpyhddet_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxexport_xpyhddet_MetaData11() {
		return xxexport_xpyhddet_MetaData11;
	}


	public static void setXxexport_xpyhddet_MetaData11(ProDataObjectMetaData xxexport_xpyhddet_MetaData11) {
		YFKSSSCPImpl.xxexport_xpyhddet_MetaData11 = xxexport_xpyhddet_MetaData11;
	}


	public static ProDataObjectMetaData getXxexport_xpyhddet_MetaData12() {
		return xxexport_xpyhddet_MetaData12;
	}


	public static void setXxexport_xpyhddet_MetaData12(ProDataObjectMetaData xxexport_xpyhddet_MetaData12) {
		YFKSSSCPImpl.xxexport_xpyhddet_MetaData12 = xxexport_xpyhddet_MetaData12;
	}


	public static ProDataGraphMetaData getXxexport_xpyhddet_DSMetaData2() {
		return xxexport_xpyhddet_DSMetaData2;
	}


	public static void setXxexport_xpyhddet_DSMetaData2(ProDataGraphMetaData xxexport_xpyhddet_DSMetaData2) {
		YFKSSSCPImpl.xxexport_xpyhddet_DSMetaData2 = xxexport_xpyhddet_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxexport_xpyhddet_MetaData21() {
		return xxexport_xpyhddet_MetaData21;
	}


	public static void setXxexport_xpyhddet_MetaData21(ProDataObjectMetaData xxexport_xpyhddet_MetaData21) {
		YFKSSSCPImpl.xxexport_xpyhddet_MetaData21 = xxexport_xpyhddet_MetaData21;
	}


	public static ProDataObjectMetaData getXxexport_xpyhddet_MetaData22() {
		return xxexport_xpyhddet_MetaData22;
	}


	public static void setXxexport_xpyhddet_MetaData22(ProDataObjectMetaData xxexport_xpyhddet_MetaData22) {
		YFKSSSCPImpl.xxexport_xpyhddet_MetaData22 = xxexport_xpyhddet_MetaData22;
	}


	public static ProDataGraphMetaData getXxinquiry_xprcdet_DSMetaData1() {
		return xxinquiry_xprcdet_DSMetaData1;
	}


	public static void setXxinquiry_xprcdet_DSMetaData1(ProDataGraphMetaData xxinquiry_xprcdet_DSMetaData1) {
		YFKSSSCPImpl.xxinquiry_xprcdet_DSMetaData1 = xxinquiry_xprcdet_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxinquiry_xprcdet_MetaData11() {
		return xxinquiry_xprcdet_MetaData11;
	}


	public static void setXxinquiry_xprcdet_MetaData11(ProDataObjectMetaData xxinquiry_xprcdet_MetaData11) {
		YFKSSSCPImpl.xxinquiry_xprcdet_MetaData11 = xxinquiry_xprcdet_MetaData11;
	}


	public static ProDataGraphMetaData getXxinquiry_xprcdet_DSMetaData2() {
		return xxinquiry_xprcdet_DSMetaData2;
	}


	public static void setXxinquiry_xprcdet_DSMetaData2(ProDataGraphMetaData xxinquiry_xprcdet_DSMetaData2) {
		YFKSSSCPImpl.xxinquiry_xprcdet_DSMetaData2 = xxinquiry_xprcdet_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxinquiry_xprcdet_MetaData21() {
		return xxinquiry_xprcdet_MetaData21;
	}


	public static void setXxinquiry_xprcdet_MetaData21(ProDataObjectMetaData xxinquiry_xprcdet_MetaData21) {
		YFKSSSCPImpl.xxinquiry_xprcdet_MetaData21 = xxinquiry_xprcdet_MetaData21;
	}


	public static ProDataObjectMetaData getXxinquiry_xprcdet_MetaData22() {
		return xxinquiry_xprcdet_MetaData22;
	}


	public static void setXxinquiry_xprcdet_MetaData22(ProDataObjectMetaData xxinquiry_xprcdet_MetaData22) {
		YFKSSSCPImpl.xxinquiry_xprcdet_MetaData22 = xxinquiry_xprcdet_MetaData22;
	}


	public static ProDataGraphMetaData getXxinquiry_xprcmstr_DSMetaData1() {
		return xxinquiry_xprcmstr_DSMetaData1;
	}


	public static void setXxinquiry_xprcmstr_DSMetaData1(ProDataGraphMetaData xxinquiry_xprcmstr_DSMetaData1) {
		YFKSSSCPImpl.xxinquiry_xprcmstr_DSMetaData1 = xxinquiry_xprcmstr_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxinquiry_xprcmstr_MetaData11() {
		return xxinquiry_xprcmstr_MetaData11;
	}


	public static void setXxinquiry_xprcmstr_MetaData11(ProDataObjectMetaData xxinquiry_xprcmstr_MetaData11) {
		YFKSSSCPImpl.xxinquiry_xprcmstr_MetaData11 = xxinquiry_xprcmstr_MetaData11;
	}


	public static ProDataObjectMetaData getXxinquiry_xprcmstr_MetaData12() {
		return xxinquiry_xprcmstr_MetaData12;
	}


	public static void setXxinquiry_xprcmstr_MetaData12(ProDataObjectMetaData xxinquiry_xprcmstr_MetaData12) {
		YFKSSSCPImpl.xxinquiry_xprcmstr_MetaData12 = xxinquiry_xprcmstr_MetaData12;
	}


	public static ProDataGraphMetaData getXxinquiry_xprcmstr_DSMetaData2() {
		return xxinquiry_xprcmstr_DSMetaData2;
	}


	public static void setXxinquiry_xprcmstr_DSMetaData2(ProDataGraphMetaData xxinquiry_xprcmstr_DSMetaData2) {
		YFKSSSCPImpl.xxinquiry_xprcmstr_DSMetaData2 = xxinquiry_xprcmstr_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxinquiry_xprcmstr_MetaData21() {
		return xxinquiry_xprcmstr_MetaData21;
	}


	public static void setXxinquiry_xprcmstr_MetaData21(ProDataObjectMetaData xxinquiry_xprcmstr_MetaData21) {
		YFKSSSCPImpl.xxinquiry_xprcmstr_MetaData21 = xxinquiry_xprcmstr_MetaData21;
	}


	public static ProDataObjectMetaData getXxinquiry_xprcmstr_MetaData22() {
		return xxinquiry_xprcmstr_MetaData22;
	}


	public static void setXxinquiry_xprcmstr_MetaData22(ProDataObjectMetaData xxinquiry_xprcmstr_MetaData22) {
		YFKSSSCPImpl.xxinquiry_xprcmstr_MetaData22 = xxinquiry_xprcmstr_MetaData22;
	}


	public static ProDataGraphMetaData getXxinquiry_xpyhddet_DSMetaData1() {
		return xxinquiry_xpyhddet_DSMetaData1;
	}


	public static void setXxinquiry_xpyhddet_DSMetaData1(ProDataGraphMetaData xxinquiry_xpyhddet_DSMetaData1) {
		YFKSSSCPImpl.xxinquiry_xpyhddet_DSMetaData1 = xxinquiry_xpyhddet_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxinquiry_xpyhddet_MetaData11() {
		return xxinquiry_xpyhddet_MetaData11;
	}


	public static void setXxinquiry_xpyhddet_MetaData11(ProDataObjectMetaData xxinquiry_xpyhddet_MetaData11) {
		YFKSSSCPImpl.xxinquiry_xpyhddet_MetaData11 = xxinquiry_xpyhddet_MetaData11;
	}


	public static ProDataObjectMetaData getXxinquiry_xpyhddet_MetaData12() {
		return xxinquiry_xpyhddet_MetaData12;
	}


	public static void setXxinquiry_xpyhddet_MetaData12(ProDataObjectMetaData xxinquiry_xpyhddet_MetaData12) {
		YFKSSSCPImpl.xxinquiry_xpyhddet_MetaData12 = xxinquiry_xpyhddet_MetaData12;
	}


	public static ProDataGraphMetaData getXxinquiry_xpyhddet_DSMetaData2() {
		return xxinquiry_xpyhddet_DSMetaData2;
	}


	public static void setXxinquiry_xpyhddet_DSMetaData2(ProDataGraphMetaData xxinquiry_xpyhddet_DSMetaData2) {
		YFKSSSCPImpl.xxinquiry_xpyhddet_DSMetaData2 = xxinquiry_xpyhddet_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxinquiry_xpyhddet_MetaData21() {
		return xxinquiry_xpyhddet_MetaData21;
	}


	public static void setXxinquiry_xpyhddet_MetaData21(ProDataObjectMetaData xxinquiry_xpyhddet_MetaData21) {
		YFKSSSCPImpl.xxinquiry_xpyhddet_MetaData21 = xxinquiry_xpyhddet_MetaData21;
	}


	public static ProDataObjectMetaData getXxinquiry_xpyhddet_MetaData22() {
		return xxinquiry_xpyhddet_MetaData22;
	}


	public static void setXxinquiry_xpyhddet_MetaData22(ProDataObjectMetaData xxinquiry_xpyhddet_MetaData22) {
		YFKSSSCPImpl.xxinquiry_xpyhddet_MetaData22 = xxinquiry_xpyhddet_MetaData22;
	}


	public static ProDataGraphMetaData getXxinquiry_xpyhmstr_DSMetaData1() {
		return xxinquiry_xpyhmstr_DSMetaData1;
	}


	public static void setXxinquiry_xpyhmstr_DSMetaData1(ProDataGraphMetaData xxinquiry_xpyhmstr_DSMetaData1) {
		YFKSSSCPImpl.xxinquiry_xpyhmstr_DSMetaData1 = xxinquiry_xpyhmstr_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxinquiry_xpyhmstr_MetaData11() {
		return xxinquiry_xpyhmstr_MetaData11;
	}


	public static void setXxinquiry_xpyhmstr_MetaData11(ProDataObjectMetaData xxinquiry_xpyhmstr_MetaData11) {
		YFKSSSCPImpl.xxinquiry_xpyhmstr_MetaData11 = xxinquiry_xpyhmstr_MetaData11;
	}


	public static ProDataObjectMetaData getXxinquiry_xpyhmstr_MetaData12() {
		return xxinquiry_xpyhmstr_MetaData12;
	}


	public static void setXxinquiry_xpyhmstr_MetaData12(ProDataObjectMetaData xxinquiry_xpyhmstr_MetaData12) {
		YFKSSSCPImpl.xxinquiry_xpyhmstr_MetaData12 = xxinquiry_xpyhmstr_MetaData12;
	}


	public static ProDataGraphMetaData getXxinquiry_xpyhmstr_DSMetaData2() {
		return xxinquiry_xpyhmstr_DSMetaData2;
	}


	public static void setXxinquiry_xpyhmstr_DSMetaData2(ProDataGraphMetaData xxinquiry_xpyhmstr_DSMetaData2) {
		YFKSSSCPImpl.xxinquiry_xpyhmstr_DSMetaData2 = xxinquiry_xpyhmstr_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxinquiry_xpyhmstr_MetaData21() {
		return xxinquiry_xpyhmstr_MetaData21;
	}


	public static void setXxinquiry_xpyhmstr_MetaData21(ProDataObjectMetaData xxinquiry_xpyhmstr_MetaData21) {
		YFKSSSCPImpl.xxinquiry_xpyhmstr_MetaData21 = xxinquiry_xpyhmstr_MetaData21;
	}


	public static ProDataObjectMetaData getXxinquiry_xpyhmstr_MetaData22() {
		return xxinquiry_xpyhmstr_MetaData22;
	}


	public static void setXxinquiry_xpyhmstr_MetaData22(ProDataObjectMetaData xxinquiry_xpyhmstr_MetaData22) {
		YFKSSSCPImpl.xxinquiry_xpyhmstr_MetaData22 = xxinquiry_xpyhmstr_MetaData22;
	}


	public static ProDataGraphMetaData getXxinqury_prhdet_DSMetaData1() {
		return xxinqury_prhdet_DSMetaData1;
	}


	public static void setXxinqury_prhdet_DSMetaData1(ProDataGraphMetaData xxinqury_prhdet_DSMetaData1) {
		YFKSSSCPImpl.xxinqury_prhdet_DSMetaData1 = xxinqury_prhdet_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxinqury_prhdet_MetaData11() {
		return xxinqury_prhdet_MetaData11;
	}


	public static void setXxinqury_prhdet_MetaData11(ProDataObjectMetaData xxinqury_prhdet_MetaData11) {
		YFKSSSCPImpl.xxinqury_prhdet_MetaData11 = xxinqury_prhdet_MetaData11;
	}


	public static ProDataObjectMetaData getXxinqury_prhdet_MetaData12() {
		return xxinqury_prhdet_MetaData12;
	}


	public static void setXxinqury_prhdet_MetaData12(ProDataObjectMetaData xxinqury_prhdet_MetaData12) {
		YFKSSSCPImpl.xxinqury_prhdet_MetaData12 = xxinqury_prhdet_MetaData12;
	}


	public static ProDataGraphMetaData getXxinqury_prhdet_DSMetaData2() {
		return xxinqury_prhdet_DSMetaData2;
	}


	public static void setXxinqury_prhdet_DSMetaData2(ProDataGraphMetaData xxinqury_prhdet_DSMetaData2) {
		YFKSSSCPImpl.xxinqury_prhdet_DSMetaData2 = xxinqury_prhdet_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxinqury_prhdet_MetaData21() {
		return xxinqury_prhdet_MetaData21;
	}


	public static void setXxinqury_prhdet_MetaData21(ProDataObjectMetaData xxinqury_prhdet_MetaData21) {
		YFKSSSCPImpl.xxinqury_prhdet_MetaData21 = xxinqury_prhdet_MetaData21;
	}


	public static ProDataObjectMetaData getXxinqury_prhdet_MetaData22() {
		return xxinqury_prhdet_MetaData22;
	}


	public static void setXxinqury_prhdet_MetaData22(ProDataObjectMetaData xxinqury_prhdet_MetaData22) {
		YFKSSSCPImpl.xxinqury_prhdet_MetaData22 = xxinqury_prhdet_MetaData22;
	}


	public static ProDataGraphMetaData getXxinqury_prhmstr_DSMetaData1() {
		return xxinqury_prhmstr_DSMetaData1;
	}


	public static void setXxinqury_prhmstr_DSMetaData1(ProDataGraphMetaData xxinqury_prhmstr_DSMetaData1) {
		YFKSSSCPImpl.xxinqury_prhmstr_DSMetaData1 = xxinqury_prhmstr_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxinqury_prhmstr_MetaData11() {
		return xxinqury_prhmstr_MetaData11;
	}


	public static void setXxinqury_prhmstr_MetaData11(ProDataObjectMetaData xxinqury_prhmstr_MetaData11) {
		YFKSSSCPImpl.xxinqury_prhmstr_MetaData11 = xxinqury_prhmstr_MetaData11;
	}


	public static ProDataObjectMetaData getXxinqury_prhmstr_MetaData12() {
		return xxinqury_prhmstr_MetaData12;
	}


	public static void setXxinqury_prhmstr_MetaData12(ProDataObjectMetaData xxinqury_prhmstr_MetaData12) {
		YFKSSSCPImpl.xxinqury_prhmstr_MetaData12 = xxinqury_prhmstr_MetaData12;
	}


	public static ProDataGraphMetaData getXxinqury_prhmstr_DSMetaData2() {
		return xxinqury_prhmstr_DSMetaData2;
	}


	public static void setXxinqury_prhmstr_DSMetaData2(ProDataGraphMetaData xxinqury_prhmstr_DSMetaData2) {
		YFKSSSCPImpl.xxinqury_prhmstr_DSMetaData2 = xxinqury_prhmstr_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxinqury_prhmstr_MetaData21() {
		return xxinqury_prhmstr_MetaData21;
	}


	public static void setXxinqury_prhmstr_MetaData21(ProDataObjectMetaData xxinqury_prhmstr_MetaData21) {
		YFKSSSCPImpl.xxinqury_prhmstr_MetaData21 = xxinqury_prhmstr_MetaData21;
	}


	public static ProDataObjectMetaData getXxinqury_prhmstr_MetaData22() {
		return xxinqury_prhmstr_MetaData22;
	}


	public static void setXxinqury_prhmstr_MetaData22(ProDataObjectMetaData xxinqury_prhmstr_MetaData22) {
		YFKSSSCPImpl.xxinqury_prhmstr_MetaData22 = xxinqury_prhmstr_MetaData22;
	}


	public static ProDataGraphMetaData getXxinqury_xasnmstr_DSMetaData1() {
		return xxinqury_xasnmstr_DSMetaData1;
	}


	public static void setXxinqury_xasnmstr_DSMetaData1(ProDataGraphMetaData xxinqury_xasnmstr_DSMetaData1) {
		YFKSSSCPImpl.xxinqury_xasnmstr_DSMetaData1 = xxinqury_xasnmstr_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxinqury_xasnmstr_MetaData11() {
		return xxinqury_xasnmstr_MetaData11;
	}


	public static void setXxinqury_xasnmstr_MetaData11(ProDataObjectMetaData xxinqury_xasnmstr_MetaData11) {
		YFKSSSCPImpl.xxinqury_xasnmstr_MetaData11 = xxinqury_xasnmstr_MetaData11;
	}


	public static ProDataObjectMetaData getXxinqury_xasnmstr_MetaData12() {
		return xxinqury_xasnmstr_MetaData12;
	}


	public static void setXxinqury_xasnmstr_MetaData12(ProDataObjectMetaData xxinqury_xasnmstr_MetaData12) {
		YFKSSSCPImpl.xxinqury_xasnmstr_MetaData12 = xxinqury_xasnmstr_MetaData12;
	}


	public static ProDataGraphMetaData getXxinqury_xasnmstr_DSMetaData2() {
		return xxinqury_xasnmstr_DSMetaData2;
	}


	public static void setXxinqury_xasnmstr_DSMetaData2(ProDataGraphMetaData xxinqury_xasnmstr_DSMetaData2) {
		YFKSSSCPImpl.xxinqury_xasnmstr_DSMetaData2 = xxinqury_xasnmstr_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxinqury_xasnmstr_MetaData21() {
		return xxinqury_xasnmstr_MetaData21;
	}


	public static void setXxinqury_xasnmstr_MetaData21(ProDataObjectMetaData xxinqury_xasnmstr_MetaData21) {
		YFKSSSCPImpl.xxinqury_xasnmstr_MetaData21 = xxinqury_xasnmstr_MetaData21;
	}


	public static ProDataObjectMetaData getXxinqury_xasnmstr_MetaData22() {
		return xxinqury_xasnmstr_MetaData22;
	}


	public static void setXxinqury_xasnmstr_MetaData22(ProDataObjectMetaData xxinqury_xasnmstr_MetaData22) {
		YFKSSSCPImpl.xxinqury_xasnmstr_MetaData22 = xxinqury_xasnmstr_MetaData22;
	}


	public static ProDataGraphMetaData getXxinqury_xpyhddet2_DSMetaData1() {
		return xxinqury_xpyhddet2_DSMetaData1;
	}


	public static void setXxinqury_xpyhddet2_DSMetaData1(ProDataGraphMetaData xxinqury_xpyhddet2_DSMetaData1) {
		YFKSSSCPImpl.xxinqury_xpyhddet2_DSMetaData1 = xxinqury_xpyhddet2_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxinqury_xpyhddet2_MetaData11() {
		return xxinqury_xpyhddet2_MetaData11;
	}


	public static void setXxinqury_xpyhddet2_MetaData11(ProDataObjectMetaData xxinqury_xpyhddet2_MetaData11) {
		YFKSSSCPImpl.xxinqury_xpyhddet2_MetaData11 = xxinqury_xpyhddet2_MetaData11;
	}


	public static ProDataGraphMetaData getXxinqury_xpyhddet2_DSMetaData2() {
		return xxinqury_xpyhddet2_DSMetaData2;
	}


	public static void setXxinqury_xpyhddet2_DSMetaData2(ProDataGraphMetaData xxinqury_xpyhddet2_DSMetaData2) {
		YFKSSSCPImpl.xxinqury_xpyhddet2_DSMetaData2 = xxinqury_xpyhddet2_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxinqury_xpyhddet2_MetaData21() {
		return xxinqury_xpyhddet2_MetaData21;
	}


	public static void setXxinqury_xpyhddet2_MetaData21(ProDataObjectMetaData xxinqury_xpyhddet2_MetaData21) {
		YFKSSSCPImpl.xxinqury_xpyhddet2_MetaData21 = xxinqury_xpyhddet2_MetaData21;
	}


	public static ProDataObjectMetaData getXxinqury_xpyhddet2_MetaData22() {
		return xxinqury_xpyhddet2_MetaData22;
	}


	public static void setXxinqury_xpyhddet2_MetaData22(ProDataObjectMetaData xxinqury_xpyhddet2_MetaData22) {
		YFKSSSCPImpl.xxinqury_xpyhddet2_MetaData22 = xxinqury_xpyhddet2_MetaData22;
	}


	public static ProDataGraphMetaData getXxprint_barcode_DSMetaData1() {
		return xxprint_barcode_DSMetaData1;
	}


	public static void setXxprint_barcode_DSMetaData1(ProDataGraphMetaData xxprint_barcode_DSMetaData1) {
		YFKSSSCPImpl.xxprint_barcode_DSMetaData1 = xxprint_barcode_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxprint_barcode_MetaData11() {
		return xxprint_barcode_MetaData11;
	}


	public static void setXxprint_barcode_MetaData11(ProDataObjectMetaData xxprint_barcode_MetaData11) {
		YFKSSSCPImpl.xxprint_barcode_MetaData11 = xxprint_barcode_MetaData11;
	}


	public static ProDataObjectMetaData getXxprint_barcode_MetaData12() {
		return xxprint_barcode_MetaData12;
	}


	public static void setXxprint_barcode_MetaData12(ProDataObjectMetaData xxprint_barcode_MetaData12) {
		YFKSSSCPImpl.xxprint_barcode_MetaData12 = xxprint_barcode_MetaData12;
	}


	public static ProDataGraphMetaData getXxprint_barcode_DSMetaData2() {
		return xxprint_barcode_DSMetaData2;
	}


	public static void setXxprint_barcode_DSMetaData2(ProDataGraphMetaData xxprint_barcode_DSMetaData2) {
		YFKSSSCPImpl.xxprint_barcode_DSMetaData2 = xxprint_barcode_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxprint_barcode_MetaData21() {
		return xxprint_barcode_MetaData21;
	}


	public static void setXxprint_barcode_MetaData21(ProDataObjectMetaData xxprint_barcode_MetaData21) {
		YFKSSSCPImpl.xxprint_barcode_MetaData21 = xxprint_barcode_MetaData21;
	}


	public static ProDataObjectMetaData getXxprint_barcode_MetaData22() {
		return xxprint_barcode_MetaData22;
	}


	public static void setXxprint_barcode_MetaData22(ProDataObjectMetaData xxprint_barcode_MetaData22) {
		YFKSSSCPImpl.xxprint_barcode_MetaData22 = xxprint_barcode_MetaData22;
	}


	public static ProDataGraphMetaData getXxupdate_xprcmstr_DSMetaData1() {
		return xxupdate_xprcmstr_DSMetaData1;
	}


	public static void setXxupdate_xprcmstr_DSMetaData1(ProDataGraphMetaData xxupdate_xprcmstr_DSMetaData1) {
		YFKSSSCPImpl.xxupdate_xprcmstr_DSMetaData1 = xxupdate_xprcmstr_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxupdate_xprcmstr_MetaData11() {
		return xxupdate_xprcmstr_MetaData11;
	}


	public static void setXxupdate_xprcmstr_MetaData11(ProDataObjectMetaData xxupdate_xprcmstr_MetaData11) {
		YFKSSSCPImpl.xxupdate_xprcmstr_MetaData11 = xxupdate_xprcmstr_MetaData11;
	}


	public static ProDataGraphMetaData getXxupdate_xprcmstr_DSMetaData2() {
		return xxupdate_xprcmstr_DSMetaData2;
	}


	public static void setXxupdate_xprcmstr_DSMetaData2(ProDataGraphMetaData xxupdate_xprcmstr_DSMetaData2) {
		YFKSSSCPImpl.xxupdate_xprcmstr_DSMetaData2 = xxupdate_xprcmstr_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxupdate_xprcmstr_MetaData21() {
		return xxupdate_xprcmstr_MetaData21;
	}


	public static void setXxupdate_xprcmstr_MetaData21(ProDataObjectMetaData xxupdate_xprcmstr_MetaData21) {
		YFKSSSCPImpl.xxupdate_xprcmstr_MetaData21 = xxupdate_xprcmstr_MetaData21;
	}


	public static ProDataGraphMetaData getXxupdate_xpyhmstr_DSMetaData1() {
		return xxupdate_xpyhmstr_DSMetaData1;
	}


	public static void setXxupdate_xpyhmstr_DSMetaData1(ProDataGraphMetaData xxupdate_xpyhmstr_DSMetaData1) {
		YFKSSSCPImpl.xxupdate_xpyhmstr_DSMetaData1 = xxupdate_xpyhmstr_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxupdate_xpyhmstr_MetaData11() {
		return xxupdate_xpyhmstr_MetaData11;
	}


	public static void setXxupdate_xpyhmstr_MetaData11(ProDataObjectMetaData xxupdate_xpyhmstr_MetaData11) {
		YFKSSSCPImpl.xxupdate_xpyhmstr_MetaData11 = xxupdate_xpyhmstr_MetaData11;
	}


	public static ProDataGraphMetaData getXxupdate_xpyhmstr_DSMetaData2() {
		return xxupdate_xpyhmstr_DSMetaData2;
	}


	public static void setXxupdate_xpyhmstr_DSMetaData2(ProDataGraphMetaData xxupdate_xpyhmstr_DSMetaData2) {
		YFKSSSCPImpl.xxupdate_xpyhmstr_DSMetaData2 = xxupdate_xpyhmstr_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxupdate_xpyhmstr_MetaData21() {
		return xxupdate_xpyhmstr_MetaData21;
	}


	public static void setXxupdate_xpyhmstr_MetaData21(ProDataObjectMetaData xxupdate_xpyhmstr_MetaData21) {
		YFKSSSCPImpl.xxupdate_xpyhmstr_MetaData21 = xxupdate_xpyhmstr_MetaData21;
	}


	public static ProDataGraphMetaData getXxview_xasndet_DSMetaData1() {
		return xxview_xasndet_DSMetaData1;
	}


	public static void setXxview_xasndet_DSMetaData1(ProDataGraphMetaData xxview_xasndet_DSMetaData1) {
		YFKSSSCPImpl.xxview_xasndet_DSMetaData1 = xxview_xasndet_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxview_xasndet_MetaData11() {
		return xxview_xasndet_MetaData11;
	}


	public static void setXxview_xasndet_MetaData11(ProDataObjectMetaData xxview_xasndet_MetaData11) {
		YFKSSSCPImpl.xxview_xasndet_MetaData11 = xxview_xasndet_MetaData11;
	}


	public static ProDataGraphMetaData getXxview_xasndet_DSMetaData2() {
		return xxview_xasndet_DSMetaData2;
	}


	public static void setXxview_xasndet_DSMetaData2(ProDataGraphMetaData xxview_xasndet_DSMetaData2) {
		YFKSSSCPImpl.xxview_xasndet_DSMetaData2 = xxview_xasndet_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxview_xasndet_MetaData21() {
		return xxview_xasndet_MetaData21;
	}


	public static void setXxview_xasndet_MetaData21(ProDataObjectMetaData xxview_xasndet_MetaData21) {
		YFKSSSCPImpl.xxview_xasndet_MetaData21 = xxview_xasndet_MetaData21;
	}


	public static ProDataObjectMetaData getXxview_xasndet_MetaData22() {
		return xxview_xasndet_MetaData22;
	}


	public static void setXxview_xasndet_MetaData22(ProDataObjectMetaData xxview_xasndet_MetaData22) {
		YFKSSSCPImpl.xxview_xasndet_MetaData22 = xxview_xasndet_MetaData22;
	}


	public static ProDataGraphMetaData getXxview_xpyhddet_DSMetaData1() {
		return xxview_xpyhddet_DSMetaData1;
	}


	public static void setXxview_xpyhddet_DSMetaData1(ProDataGraphMetaData xxview_xpyhddet_DSMetaData1) {
		YFKSSSCPImpl.xxview_xpyhddet_DSMetaData1 = xxview_xpyhddet_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxview_xpyhddet_MetaData11() {
		return xxview_xpyhddet_MetaData11;
	}


	public static void setXxview_xpyhddet_MetaData11(ProDataObjectMetaData xxview_xpyhddet_MetaData11) {
		YFKSSSCPImpl.xxview_xpyhddet_MetaData11 = xxview_xpyhddet_MetaData11;
	}


	public static ProDataGraphMetaData getXxview_xpyhddet_DSMetaData2() {
		return xxview_xpyhddet_DSMetaData2;
	}


	public static void setXxview_xpyhddet_DSMetaData2(ProDataGraphMetaData xxview_xpyhddet_DSMetaData2) {
		YFKSSSCPImpl.xxview_xpyhddet_DSMetaData2 = xxview_xpyhddet_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxview_xpyhddet_MetaData21() {
		return xxview_xpyhddet_MetaData21;
	}


	public static void setXxview_xpyhddet_MetaData21(ProDataObjectMetaData xxview_xpyhddet_MetaData21) {
		YFKSSSCPImpl.xxview_xpyhddet_MetaData21 = xxview_xpyhddet_MetaData21;
	}


	public static ProDataObjectMetaData getXxview_xpyhddet_MetaData22() {
		return xxview_xpyhddet_MetaData22;
	}


	public static void setXxview_xpyhddet_MetaData22(ProDataObjectMetaData xxview_xpyhddet_MetaData22) {
		YFKSSSCPImpl.xxview_xpyhddet_MetaData22 = xxview_xpyhddet_MetaData22;
	}

	

	public static ProDataGraphMetaData getXxview_forecast_DSMetaData1() {
		return xxview_forecast_DSMetaData1;
	}


	public static void setXxview_forecast_DSMetaData1(ProDataGraphMetaData xxview_forecast_DSMetaData1) {
		YFKSSSCPImpl.xxview_forecast_DSMetaData1 = xxview_forecast_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxview_forecast_MetaData11() {
		return xxview_forecast_MetaData11;
	}


	public static void setXxview_forecast_MetaData11(ProDataObjectMetaData xxview_forecast_MetaData11) {
		YFKSSSCPImpl.xxview_forecast_MetaData11 = xxview_forecast_MetaData11;
	}


	public static ProDataGraphMetaData getXxview_forecast_DSMetaData2() {
		return xxview_forecast_DSMetaData2;
	}


	public static void setXxview_forecast_DSMetaData2(ProDataGraphMetaData xxview_forecast_DSMetaData2) {
		YFKSSSCPImpl.xxview_forecast_DSMetaData2 = xxview_forecast_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxview_forecast_MetaData21() {
		return xxview_forecast_MetaData21;
	}


	public static void setXxview_forecast_MetaData21(ProDataObjectMetaData xxview_forecast_MetaData21) {
		YFKSSSCPImpl.xxview_forecast_MetaData21 = xxview_forecast_MetaData21;
	}


	public static ProDataObjectMetaData getXxview_forecast_MetaData22() {
		return xxview_forecast_MetaData22;
	}


	public static void setXxview_forecast_MetaData22(ProDataObjectMetaData xxview_forecast_MetaData22) {
		YFKSSSCPImpl.xxview_forecast_MetaData22 = xxview_forecast_MetaData22;
	}


	public static ProDataObjectMetaData getXxview_forecast_MetaData12() {
		return xxview_forecast_MetaData12;
	}


	public static void setXxview_forecast_MetaData12(ProDataObjectMetaData xxview_forecast_MetaData12) {
		YFKSSSCPImpl.xxview_forecast_MetaData12 = xxview_forecast_MetaData12;
	}


	public static ProDataGraphMetaData getXxinquiry_claimdet_DSMetaData1() {
		return xxinquiry_claimdet_DSMetaData1;
	}


	public static void setXxinquiry_claimdet_DSMetaData1(ProDataGraphMetaData xxinquiry_claimdet_DSMetaData1) {
		YFKSSSCPImpl.xxinquiry_claimdet_DSMetaData1 = xxinquiry_claimdet_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxinquiry_claimdet_MetaData11() {
		return xxinquiry_claimdet_MetaData11;
	}


	public static void setXxinquiry_claimdet_MetaData11(ProDataObjectMetaData xxinquiry_claimdet_MetaData11) {
		YFKSSSCPImpl.xxinquiry_claimdet_MetaData11 = xxinquiry_claimdet_MetaData11;
	}


	public static ProDataGraphMetaData getXxinquiry_claimdet_DSMetaData2() {
		return xxinquiry_claimdet_DSMetaData2;
	}


	public static void setXxinquiry_claimdet_DSMetaData2(ProDataGraphMetaData xxinquiry_claimdet_DSMetaData2) {
		YFKSSSCPImpl.xxinquiry_claimdet_DSMetaData2 = xxinquiry_claimdet_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxinquiry_claimdet_MetaData21() {
		return xxinquiry_claimdet_MetaData21;
	}


	public static void setXxinquiry_claimdet_MetaData21(ProDataObjectMetaData xxinquiry_claimdet_MetaData21) {
		YFKSSSCPImpl.xxinquiry_claimdet_MetaData21 = xxinquiry_claimdet_MetaData21;
	}


	public static ProDataObjectMetaData getXxinquiry_claimdet_MetaData22() {
		return xxinquiry_claimdet_MetaData22;
	}


	public static void setXxinquiry_claimdet_MetaData22(ProDataObjectMetaData xxinquiry_claimdet_MetaData22) {
		YFKSSSCPImpl.xxinquiry_claimdet_MetaData22 = xxinquiry_claimdet_MetaData22;
	}

	

	public static ProDataGraphMetaData getXxinquiry_cinvoice_DSMetaData1() {
		return xxinquiry_cinvoice_DSMetaData1;
	}


	public static void setXxinquiry_cinvoice_DSMetaData1(ProDataGraphMetaData xxinquiry_cinvoice_DSMetaData1) {
		YFKSSSCPImpl.xxinquiry_cinvoice_DSMetaData1 = xxinquiry_cinvoice_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxinquiry_cinvoice_MetaData11() {
		return xxinquiry_cinvoice_MetaData11;
	}


	public static void setXxinquiry_cinvoice_MetaData11(ProDataObjectMetaData xxinquiry_cinvoice_MetaData11) {
		YFKSSSCPImpl.xxinquiry_cinvoice_MetaData11 = xxinquiry_cinvoice_MetaData11;
	}


	public static ProDataObjectMetaData getXxinquiry_cinvoice_MetaData12() {
		return xxinquiry_cinvoice_MetaData12;
	}


	public static void setXxinquiry_cinvoice_MetaData12(ProDataObjectMetaData xxinquiry_cinvoice_MetaData12) {
		YFKSSSCPImpl.xxinquiry_cinvoice_MetaData12 = xxinquiry_cinvoice_MetaData12;
	}


	public static ProDataGraphMetaData getXxinquiry_cinvoice_DSMetaData2() {
		return xxinquiry_cinvoice_DSMetaData2;
	}


	public static void setXxinquiry_cinvoice_DSMetaData2(ProDataGraphMetaData xxinquiry_cinvoice_DSMetaData2) {
		YFKSSSCPImpl.xxinquiry_cinvoice_DSMetaData2 = xxinquiry_cinvoice_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxinquiry_cinvoice_MetaData21() {
		return xxinquiry_cinvoice_MetaData21;
	}


	public static void setXxinquiry_cinvoice_MetaData21(ProDataObjectMetaData xxinquiry_cinvoice_MetaData21) {
		YFKSSSCPImpl.xxinquiry_cinvoice_MetaData21 = xxinquiry_cinvoice_MetaData21;
	}


	public static ProDataObjectMetaData getXxinquiry_cinvoice_MetaData22() {
		return xxinquiry_cinvoice_MetaData22;
	}


	public static void setXxinquiry_cinvoice_MetaData22(ProDataObjectMetaData xxinquiry_cinvoice_MetaData22) {
		YFKSSSCPImpl.xxinquiry_cinvoice_MetaData22 = xxinquiry_cinvoice_MetaData22;
	}


	public static ProDataGraphMetaData getXxinquiry_payment_DSMetaData1() {
		return xxinquiry_payment_DSMetaData1;
	}


	public static void setXxinquiry_payment_DSMetaData1(ProDataGraphMetaData xxinquiry_payment_DSMetaData1) {
		YFKSSSCPImpl.xxinquiry_payment_DSMetaData1 = xxinquiry_payment_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxinquiry_payment_MetaData11() {
		return xxinquiry_payment_MetaData11;
	}


	public static void setXxinquiry_payment_MetaData11(ProDataObjectMetaData xxinquiry_payment_MetaData11) {
		YFKSSSCPImpl.xxinquiry_payment_MetaData11 = xxinquiry_payment_MetaData11;
	}


	public static ProDataObjectMetaData getXxinquiry_payment_MetaData12() {
		return xxinquiry_payment_MetaData12;
	}


	public static void setXxinquiry_payment_MetaData12(ProDataObjectMetaData xxinquiry_payment_MetaData12) {
		YFKSSSCPImpl.xxinquiry_payment_MetaData12 = xxinquiry_payment_MetaData12;
	}


	public static ProDataGraphMetaData getXxinquiry_payment_DSMetaData2() {
		return xxinquiry_payment_DSMetaData2;
	}


	public static void setXxinquiry_payment_DSMetaData2(ProDataGraphMetaData xxinquiry_payment_DSMetaData2) {
		YFKSSSCPImpl.xxinquiry_payment_DSMetaData2 = xxinquiry_payment_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxinquiry_payment_MetaData21() {
		return xxinquiry_payment_MetaData21;
	}


	public static void setXxinquiry_payment_MetaData21(ProDataObjectMetaData xxinquiry_payment_MetaData21) {
		YFKSSSCPImpl.xxinquiry_payment_MetaData21 = xxinquiry_payment_MetaData21;
	}


	public static ProDataObjectMetaData getXxinquiry_payment_MetaData22() {
		return xxinquiry_payment_MetaData22;
	}


	public static void setXxinquiry_payment_MetaData22(ProDataObjectMetaData xxinquiry_payment_MetaData22) {
		YFKSSSCPImpl.xxinquiry_payment_MetaData22 = xxinquiry_payment_MetaData22;
	}
	
	
	


	public static ProDataGraphMetaData getXxprint_barcode2_DSMetaData1() {
		return xxprint_barcode2_DSMetaData1;
	}


	public static void setXxprint_barcode2_DSMetaData1(ProDataGraphMetaData xxprint_barcode2_DSMetaData1) {
		YFKSSSCPImpl.xxprint_barcode2_DSMetaData1 = xxprint_barcode2_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxprint_barcode2_MetaData11() {
		return xxprint_barcode2_MetaData11;
	}


	public static void setXxprint_barcode2_MetaData11(ProDataObjectMetaData xxprint_barcode2_MetaData11) {
		YFKSSSCPImpl.xxprint_barcode2_MetaData11 = xxprint_barcode2_MetaData11;
	}


	public static ProDataObjectMetaData getXxprint_barcode2_MetaData12() {
		return xxprint_barcode2_MetaData12;
	}


	public static void setXxprint_barcode2_MetaData12(ProDataObjectMetaData xxprint_barcode2_MetaData12) {
		YFKSSSCPImpl.xxprint_barcode2_MetaData12 = xxprint_barcode2_MetaData12;
	}


	public static ProDataGraphMetaData getXxprint_barcode2_DSMetaData2() {
		return xxprint_barcode2_DSMetaData2;
	}


	public static void setXxprint_barcode2_DSMetaData2(ProDataGraphMetaData xxprint_barcode2_DSMetaData2) {
		YFKSSSCPImpl.xxprint_barcode2_DSMetaData2 = xxprint_barcode2_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxprint_barcode2_MetaData21() {
		return xxprint_barcode2_MetaData21;
	}


	public static void setXxprint_barcode2_MetaData21(ProDataObjectMetaData xxprint_barcode2_MetaData21) {
		YFKSSSCPImpl.xxprint_barcode2_MetaData21 = xxprint_barcode2_MetaData21;
	}


	public static ProDataObjectMetaData getXxprint_barcode2_MetaData22() {
		return xxprint_barcode2_MetaData22;
	}


	public static void setXxprint_barcode2_MetaData22(ProDataObjectMetaData xxprint_barcode2_MetaData22) {
		YFKSSSCPImpl.xxprint_barcode2_MetaData22 = xxprint_barcode2_MetaData22;
	}


	public YFKSSSCPImpl(String     appName,
                            IPoolProps props,
                            IAppLogger log)
        throws Open4GLException, ConnectException, SystemErrorException
    {
        super(appName,
              props,
              log,
              null);
    }


	/* 
	*/
	public String xxcreate_xasndet(ProDataGraph input_xasndet, ProDataGraphHolder export_xasndet)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xasndet, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxcreate_xasndet_MetaSchema = new MetaSchema();
		xxcreate_xasndet_MetaSchema.addProDataGraphSchema(xxcreate_xasndet_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxcreate_xasndet_MetaSchema.addProDataGraphSchema(xxcreate_xasndet_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxcreate_xasndet.p", params, xxcreate_xasndet_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xasndet.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxexport_xasndet(ProDataGraph input_xasndet, ProDataGraphHolder export_xasndet)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xasndet, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxexport_xasndet_MetaSchema = new MetaSchema();
		xxexport_xasndet_MetaSchema.addProDataGraphSchema(xxexport_xasndet_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxexport_xasndet_MetaSchema.addProDataGraphSchema(xxexport_xasndet_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxexport_xasndet.p", params, xxexport_xasndet_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xasndet.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxexport_xpyhddet(ProDataGraph input_xpyhddet, ProDataGraphHolder export_xpyhddet)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xpyhddet, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxexport_xpyhddet_MetaSchema = new MetaSchema();
		xxexport_xpyhddet_MetaSchema.addProDataGraphSchema(xxexport_xpyhddet_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxexport_xpyhddet_MetaSchema.addProDataGraphSchema(xxexport_xpyhddet_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxexport_xpyhddet.p", params, xxexport_xpyhddet_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xpyhddet.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxinquiry_xprcdet(ProDataGraph input_xprcd, ProDataGraphHolder export_xprcd)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xprcd, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxinquiry_xprcdet_MetaSchema = new MetaSchema();
		xxinquiry_xprcdet_MetaSchema.addProDataGraphSchema(xxinquiry_xprcdet_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxinquiry_xprcdet_MetaSchema.addProDataGraphSchema(xxinquiry_xprcdet_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxinquiry_xprcdet.p", params, xxinquiry_xprcdet_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xprcd.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxinquiry_xprcmstr(ProDataGraph input_xprc, ProDataGraphHolder export_xprc)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xprc, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxinquiry_xprcmstr_MetaSchema = new MetaSchema();
		xxinquiry_xprcmstr_MetaSchema.addProDataGraphSchema(xxinquiry_xprcmstr_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxinquiry_xprcmstr_MetaSchema.addProDataGraphSchema(xxinquiry_xprcmstr_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxinquiry_xprcmstr.p", params, xxinquiry_xprcmstr_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xprc.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxinquiry_xpyhddet(ProDataGraph input_xpyhddet, ProDataGraphHolder export_xpyhddet)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xpyhddet, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxinquiry_xpyhddet_MetaSchema = new MetaSchema();
		xxinquiry_xpyhddet_MetaSchema.addProDataGraphSchema(xxinquiry_xpyhddet_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxinquiry_xpyhddet_MetaSchema.addProDataGraphSchema(xxinquiry_xpyhddet_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxinquiry_xpyhddet.p", params, xxinquiry_xpyhddet_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xpyhddet.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxinquiry_xpyhmstr(ProDataGraph input_xpyhmstr, ProDataGraphHolder export_xpyhmstr)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xpyhmstr, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxinquiry_xpyhmstr_MetaSchema = new MetaSchema();
		xxinquiry_xpyhmstr_MetaSchema.addProDataGraphSchema(xxinquiry_xpyhmstr_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxinquiry_xpyhmstr_MetaSchema.addProDataGraphSchema(xxinquiry_xpyhmstr_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() + "xxinquiry_xpyhmstr.p", params, xxinquiry_xpyhmstr_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xpyhmstr.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxinqury_prhdet(ProDataGraph input_prhdet, ProDataGraphHolder export_prhdet)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_prhdet, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxinqury_prhdet_MetaSchema = new MetaSchema();
		xxinqury_prhdet_MetaSchema.addProDataGraphSchema(xxinqury_prhdet_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxinqury_prhdet_MetaSchema.addProDataGraphSchema(xxinqury_prhdet_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxinqury_prhdet.p", params, xxinqury_prhdet_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_prhdet.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxinqury_prhmstr(ProDataGraph input_prhmstr, ProDataGraphHolder export_prhmstr)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_prhmstr, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxinqury_prhmstr_MetaSchema = new MetaSchema();
		xxinqury_prhmstr_MetaSchema.addProDataGraphSchema(xxinqury_prhmstr_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxinqury_prhmstr_MetaSchema.addProDataGraphSchema(xxinqury_prhmstr_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxinqury_prhmstr.p", params, xxinqury_prhmstr_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_prhmstr.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxinqury_xasnmstr(ProDataGraph input_xasnmstr, ProDataGraphHolder export_xasnmstr)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xasnmstr, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxinqury_xasnmstr_MetaSchema = new MetaSchema();
		xxinqury_xasnmstr_MetaSchema.addProDataGraphSchema(xxinqury_xasnmstr_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxinqury_xasnmstr_MetaSchema.addProDataGraphSchema(xxinqury_xasnmstr_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxinqury_xasnmstr.p", params, xxinqury_xasnmstr_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xasnmstr.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxinqury_xpyhddet2(ProDataGraph input_xpyhddet, ProDataGraphHolder export_xpyhddet)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xpyhddet, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxinqury_xpyhddet2_MetaSchema = new MetaSchema();
		xxinqury_xpyhddet2_MetaSchema.addProDataGraphSchema(xxinqury_xpyhddet2_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxinqury_xpyhddet2_MetaSchema.addProDataGraphSchema(xxinqury_xpyhddet2_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxinqury_xpyhddet2.p", params, xxinqury_xpyhddet2_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xpyhddet.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxprint_barcode(ProDataGraph input_bcddet, ProDataGraphHolder export_bcddet)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_bcddet, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxprint_barcode_MetaSchema = new MetaSchema();
		xxprint_barcode_MetaSchema.addProDataGraphSchema(xxprint_barcode_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxprint_barcode_MetaSchema.addProDataGraphSchema(xxprint_barcode_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxprint_barcode.p", params, xxprint_barcode_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_bcddet.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxupdate_xprcmstr(ProDataGraph input_xprc, ProDataGraphHolder export_xprc)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xprc, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxupdate_xprcmstr_MetaSchema = new MetaSchema();
		xxupdate_xprcmstr_MetaSchema.addProDataGraphSchema(xxupdate_xprcmstr_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxupdate_xprcmstr_MetaSchema.addProDataGraphSchema(xxupdate_xprcmstr_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxupdate_xprcmstr.p", params, xxupdate_xprcmstr_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xprc.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxupdate_xpyhmstr(ProDataGraph input_xpyhmstr, ProDataGraphHolder export_xpyhmstr)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xpyhmstr, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxupdate_xpyhmstr_MetaSchema = new MetaSchema();
		xxupdate_xpyhmstr_MetaSchema.addProDataGraphSchema(xxupdate_xpyhmstr_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxupdate_xpyhmstr_MetaSchema.addProDataGraphSchema(xxupdate_xpyhmstr_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxupdate_xpyhmstr.p", params, xxupdate_xpyhmstr_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xpyhmstr.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxview_xasndet(ProDataGraph input_xasndet, ProDataGraphHolder export_xasndet)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xasndet, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxview_xasndet_MetaSchema = new MetaSchema();
		xxview_xasndet_MetaSchema.addProDataGraphSchema(xxview_xasndet_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxview_xasndet_MetaSchema.addProDataGraphSchema(xxview_xasndet_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxview_xasndet.p", params, xxview_xasndet_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xasndet.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxview_xpyhddet(ProDataGraph input_xpyhddet, ProDataGraphHolder export_xpyhddet)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xpyhddet, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxview_xpyhddet_MetaSchema = new MetaSchema();
		xxview_xpyhddet_MetaSchema.addProDataGraphSchema(xxview_xpyhddet_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxview_xpyhddet_MetaSchema.addProDataGraphSchema(xxview_xpyhddet_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxview_xpyhddet.p", params, xxview_xpyhddet_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xpyhddet.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxview_forecast(ProDataGraph input_scpfcast, ProDataGraphHolder export_scpfcast)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_scpfcast, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxview_forecast_MetaSchema = new MetaSchema();
		xxview_forecast_MetaSchema.addProDataGraphSchema(xxview_forecast_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxview_forecast_MetaSchema.addProDataGraphSchema(xxview_forecast_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxview_forecast.p", params, xxview_forecast_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_scpfcast.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}
	
	
	/* 
	*/
	public String xxinquiry_claimdet(ProDataGraph input_xprcd, ProDataGraphHolder export_xprcd)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xprcd, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxinquiry_claimdet_MetaSchema = new MetaSchema();
		xxinquiry_claimdet_MetaSchema.addProDataGraphSchema(xxinquiry_claimdet_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxinquiry_claimdet_MetaSchema.addProDataGraphSchema(xxinquiry_claimdet_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure(QADConfg.getQadFilePath() +"xxinquiry_claimdet.p", params, xxinquiry_claimdet_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xprcd.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}
	
	/* 
	*/
	public String xxinquiry_cinvoice(ProDataGraph input_xprc, ProDataGraphHolder export_xprc)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xprc, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxinquiry_cinvoice_MetaSchema = new MetaSchema();
		xxinquiry_cinvoice_MetaSchema.addProDataGraphSchema(xxinquiry_cinvoice_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxinquiry_cinvoice_MetaSchema.addProDataGraphSchema(xxinquiry_cinvoice_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure("xxinquiry_cinvoice.p", params, xxinquiry_cinvoice_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xprc.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxinquiry_payment(ProDataGraph input_xprc, ProDataGraphHolder export_xprc)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_xprc, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxinquiry_payment_MetaSchema = new MetaSchema();
		xxinquiry_payment_MetaSchema.addProDataGraphSchema(xxinquiry_payment_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxinquiry_payment_MetaSchema.addProDataGraphSchema(xxinquiry_payment_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure("xxinquiry_payment.p", params, xxinquiry_payment_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_xprc.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}
	
	
	
	static ProDataGraphMetaData xxprint_barcode2_DSMetaData1;

	static ProDataObjectMetaData xxprint_barcode2_MetaData11;

	static ProDataObjectMetaData xxprint_barcode2_MetaData12;

	static ProDataGraphMetaData xxprint_barcode2_DSMetaData2;

	static ProDataObjectMetaData xxprint_barcode2_MetaData21;

	static ProDataObjectMetaData xxprint_barcode2_MetaData22;


	static
	{
		xxprint_barcode2_DSMetaData1 = new ProDataGraphMetaData(0, "input_bcddet", 1, ParameterSet.INPUT);
		xxprint_barcode2_MetaData11 = new ProDataObjectMetaData("tt_suppcode_in", 2, false, 0, null, null, null);
		xxprint_barcode2_MetaData11.setFieldDesc(1, "tt_suppcodei_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxprint_barcode2_MetaData11.setFieldDesc(2, "tt_suppcodei_suppcode", 0, Parameter.PRO_CHARACTER,1,0);
		xxprint_barcode2_DSMetaData1.addTable(xxprint_barcode2_MetaData11);
		xxprint_barcode2_MetaData12 = new ProDataObjectMetaData("tt_bcdet_in", 7, false, 0, null, null, null);
		xxprint_barcode2_MetaData12.setFieldDesc(1, "tt_bcdeti_partnbr", 0, Parameter.PRO_CHARACTER,0,0);
		xxprint_barcode2_MetaData12.setFieldDesc(2, "tt_bcdeti_lots", 0, Parameter.PRO_CHARACTER,1,0);
		xxprint_barcode2_MetaData12.setFieldDesc(3, "tt_bcdeti_vend_lots", 0, Parameter.PRO_CHARACTER,2,0);
		xxprint_barcode2_MetaData12.setFieldDesc(4, "tt_bcdeti_qty", 0, Parameter.PRO_DECIMAL,3,0);
		xxprint_barcode2_MetaData12.setFieldDesc(5, "tt_bcdeti_date", 0, Parameter.PRO_CHARACTER,4,0);
		xxprint_barcode2_MetaData12.setFieldDesc(6, "tt_new_bcdeti_bcdetoid", 0, Parameter.PRO_CHARACTER,5,0);
		xxprint_barcode2_MetaData12.setFieldDesc(7, "tt_bcdeti_pktype", 0, Parameter.PRO_CHARACTER,6,0);
		xxprint_barcode2_DSMetaData1.addTable(xxprint_barcode2_MetaData12);
		xxprint_barcode2_DSMetaData2 = new ProDataGraphMetaData(0, "export_bcddet", 2, ParameterSet.OUTPUT);
		xxprint_barcode2_MetaData21 = new ProDataObjectMetaData("tt_bcdet_out", 11, false, 0, null, null, null);
		xxprint_barcode2_MetaData21.setFieldDesc(1, "tt_bcdeto_date", 0, Parameter.PRO_CHARACTER,0,0);
		xxprint_barcode2_MetaData21.setFieldDesc(2, "tt_bcdeto_partnbr", 0, Parameter.PRO_CHARACTER,1,0);
		xxprint_barcode2_MetaData21.setFieldDesc(3, "tt_bcdeto_partdesc", 0, Parameter.PRO_CHARACTER,2,0);
		xxprint_barcode2_MetaData21.setFieldDesc(4, "tt_bcdeto_lots", 0, Parameter.PRO_CHARACTER,3,0);
		xxprint_barcode2_MetaData21.setFieldDesc(5, "tt_bcdeto_qty", 0, Parameter.PRO_DECIMAL,4,0);
		xxprint_barcode2_MetaData21.setFieldDesc(6, "tt_bcdeto_bcinfo1", 0, Parameter.PRO_CHARACTER,5,0);
		xxprint_barcode2_MetaData21.setFieldDesc(7, "tt_bcdeto_suppname", 0, Parameter.PRO_CHARACTER,6,0);
		xxprint_barcode2_MetaData21.setFieldDesc(8, "tt_bcdeto_bcinfo2", 0, Parameter.PRO_CHARACTER,7,0);
		xxprint_barcode2_MetaData21.setFieldDesc(9, "tt_bcdeto_serial", 0, Parameter.PRO_CHARACTER,8,0);
		xxprint_barcode2_MetaData21.setFieldDesc(10, "tt_bcdeto_bcdetoid", 0, Parameter.PRO_CHARACTER,9,0);
		xxprint_barcode2_MetaData21.setFieldDesc(11, "tt_bcdeto_bcnon", 0, Parameter.PRO_CHARACTER,10,0);
		xxprint_barcode2_DSMetaData2.addTable(xxprint_barcode2_MetaData21);
		xxprint_barcode2_MetaData22 = new ProDataObjectMetaData("tt_err_out", 4, false, 0, null, null, null);
		xxprint_barcode2_MetaData22.setFieldDesc(1, "tt_erro_bcdetoid", 0, Parameter.PRO_CHARACTER,0,0);
		xxprint_barcode2_MetaData22.setFieldDesc(2, "tt_erro_errid", 0, Parameter.PRO_INTEGER,1,0);
		xxprint_barcode2_MetaData22.setFieldDesc(3, "tt_erro_errsens", 0, Parameter.PRO_INTEGER,2,0);
		xxprint_barcode2_MetaData22.setFieldDesc(4, "tt_erro_msg", 0, Parameter.PRO_CHARACTER,3,0);
		xxprint_barcode2_DSMetaData2.addTable(xxprint_barcode2_MetaData22);

	}


	/* 
	*/
	public String xxprint_barcode2(ProDataGraph input_bcddet, ProDataGraphHolder export_bcddet)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_bcddet, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxprint_barcode2_MetaSchema = new MetaSchema();
		xxprint_barcode2_MetaSchema.addProDataGraphSchema(xxprint_barcode2_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxprint_barcode2_MetaSchema.addProDataGraphSchema(xxprint_barcode2_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure("xxprint_barcode2.p", params, xxprint_barcode2_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_bcddet.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}


}
