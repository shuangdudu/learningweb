package com.miaomiao.it.learning.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class FinalExportPdf {
	//	9列的表格以及单元格的宽度。
	public static final float[] InitTable = new float[] {13.56f,20.56f, 12.45f,11.16f, 11.16f,11.65f, 11.68f, 11.65f,7.28f}; 
	//设置table2的row的高度，调整行间距
	public static final float Table2_Row_Height = 20f;
	
//	public static boolean dealWithPdf(List<?> list,Map<String,String> sum) throws DocumentException, IOException{
		public static boolean dealWithPdf() throws DocumentException, IOException{
		

		String imagePath=FinalExportPdf.class.getClassLoader().getResource("image").getPath();
		imagePath = imagePath.substring(1);
		String fontPath=FinalExportPdf.class.getClassLoader().getResource("font").getPath();
		fontPath = fontPath.substring(1);
		//实例化文档对象
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		//PDF文档中输出中文字体
		//itext默认字体
		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		//添加字体--宋体
		BaseFont bfChinese1 = BaseFont.createFont(fontPath+File.separator+"SIMSUN.TTC,1", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);

		
		//设置字体
		Font biaotouFont= new Font(bfChinese, 16, Font.BOLD);//加入document：
		Font zhengwenFont = new Font(bfChinese,10,Font.NORMAL);
		Font dataFont = new Font(bfChinese, 8, Font.NORMAL);
		Font songti = new Font(bfChinese1, 10, Font.NORMAL);
		
		//文件输出流
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\result-new.pdf"));
		document.open();
		document.newPage();
		
		
        //添加CCB的logo
        Image image1 = Image.getInstance(imagePath+File.separator+"ccb.jpg");
        //设置logo显示比例
        image1.scaleAbsolute(150, 30);
        //Add to document
        document.add(image1);
        
        //添加标题
		Paragraph paragraphHeard = new Paragraph("实物贵金属产品加工订货单", biaotouFont);
		//段落居中
		paragraphHeard.setAlignment(1);
		document.add(paragraphHeard);
		
		//添加表单上方的日期
		PdfPTable table0 = new PdfPTable(InitTable);
		//表单显示比例
        table0.setWidthPercentage(100);
        //设置与上个元素的上边距
        table0.setSpacingBefore(8f); // Space before table
      //设置与上个元素的下边距
        table0.setSpacingAfter(0f);
        PdfPCell cell0_1 = new PdfPCell(new Phrase("订货单编号：",zhengwenFont));
        //合并单元格
        cell0_1.setColspan(2);
        //设置表单内的元素垂直居中
        cell0_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //隐藏表单的边框
        cell0_1.setBorderColor(BaseColor.WHITE);
        table0.addCell(cell0_1); 
        
        PdfPCell cell0_2 = new PdfPCell(new Phrase("订货单下达日期：  年   月   日",zhengwenFont));
        cell0_2.setColspan(4);
        cell0_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell0_2.setBorderColor(BaseColor.WHITE);
        table0.addCell(cell0_2); 

             
        PdfPCell cell0_4 = new PdfPCell(new Phrase("订单生效日期：   年   月   日",zhengwenFont));
        cell0_4.setColspan(3);
        cell0_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell0_4.setBorderColor(BaseColor.WHITE);
        table0.addCell(cell0_4);
        
        document.add(table0);
		
	    PdfPTable table = new PdfPTable(InitTable);// 9列的表格以及单元格的宽度。
        table.setWidthPercentage(100);
        table.setSpacingBefore(5f); 

        //设置table的表头
        table.addCell(cellVerticalCenter("产品代码", zhengwenFont));
        table.addCell(cellVerticalCenter("产品名称", zhengwenFont));
//        table.addCell(cellVerticalCenter("单件/套                                            重量（克）", zhengwenFont));
        table.addCell(cellVerticalCenter("单件/套 \n重量（克）", zhengwenFont));
        table.addCell(cellVerticalCenter("加工数量（块/套）", zhengwenFont));
        table.addCell(cellVerticalCenter("重量小计（克）", zhengwenFont));
        table.addCell(cellVerticalCenter("证书数量（张/套）", zhengwenFont));
        table.addCell(cellVerticalCenter("交货日期", zhengwenFont));
        table.addCell(cellVerticalCenter("交货地点与方式", zhengwenFont));
        table.addCell(cellVerticalCenter("备注", zhengwenFont));
        
        
//        if(list == null || list.size() == 0){
//        	System.out.println("抛出异常信息");
//        }
//        //添加空行的行数
//        int blankRows = 20 - list.size();
//        for(int i=0;i<list.size();i++){
//        	Book book = list.get(i); 
//        	if(i == 0){
//                table.addCell(cellVerticalCenter("2.1", dataFont));
//                table.addCell(cellVerticalCenter("2.2", dataFont));
//                table.addCell(cellVerticalCenter("2.3", dataFont));
//                table.addCell(cellVerticalCenter("2.4", dataFont));
//                table.addCell(cellVerticalCenter("2.5", dataFont));
//                table.addCell(cellVerticalCenter("2.6", dataFont));
//                table.addCell(cellVerticalCenter("2.7", dataFont));
//                PdfPCell cell = cellVerticalCenter("  ",dataFont);
////                设置表单的第2行交货地点和交货方式列合并单元格
//                cell.setRowspan(20);
//                table.addCell(cell);
//                //设置备注列，没有值，必须要用空字符串
//                table.addCell(cellVerticalCenter("  ", dataFont));
//        	}
//        	if(i > 0){
//                table.addCell(cellVerticalCenter("3.1111111111", dataFont));
//                table.addCell(cellVerticalCenter("3.2", dataFont));
//                table.addCell(cellVerticalCenter("3.3", dataFont));
//                table.addCell(cellVerticalCenter("3.4", dataFont));
//                table.addCell(cellVerticalCenter("3.5", dataFont));
//                table.addCell(cellVerticalCenter("3.6", dataFont));
//                table.addCell(cellVerticalCenter("3.7", dataFont));
//                table.addCell(cellVerticalCenter(" ", dataFont));
//        	}
//        }
//        //动态生成空白行
//        for(int j=0;j<blankRows;j++){
//       	 table.addCell(cellVerticalCenter(" ", dataFont));
//            table.addCell(cellVerticalCenter(" ", dataFont));
//            table.addCell(cellVerticalCenter(" ", dataFont));
//            table.addCell(cellVerticalCenter(" ", dataFont));
//            table.addCell(cellVerticalCenter(" ", dataFont));
//            table.addCell(cellVerticalCenter(" ", dataFont));
//            table.addCell(cellVerticalCenter(" ", dataFont));
//            table.addCell(cellVerticalCenter(" ", dataFont));
//       }
        
        
        table.addCell(cellVerticalCenter("2.1", dataFont));
        table.addCell(cellVerticalCenter("2.2", dataFont));
        table.addCell(cellVerticalCenter("2.3", dataFont));
        table.addCell(cellVerticalCenter("2.4", dataFont));
        table.addCell(cellVerticalCenter("2.5", dataFont));
        table.addCell(cellVerticalCenter("2.6", dataFont));
        table.addCell(cellVerticalCenter("2.7", dataFont));
        PdfPCell cell = cellVerticalCenter("   ",dataFont);
        cell.setRowspan(20);
//        table.addCell(new Paragraph("2.8", zhengwenFont));
        table.addCell(cell);
        table.addCell(cellVerticalCenter("  ", dataFont));
        

        table.addCell(cellVerticalCenter("3.1111111111", dataFont));
        table.addCell(cellVerticalCenter("3.2", dataFont));
        table.addCell(cellVerticalCenter("3.3", dataFont));
        table.addCell(cellVerticalCenter("3.4", dataFont));
        table.addCell(cellVerticalCenter("3.5", dataFont));
        table.addCell(cellVerticalCenter("3.6", dataFont));
        table.addCell(cellVerticalCenter("3.7", dataFont));
        table.addCell(cellVerticalCenter(" ", dataFont));
        
        for(int i=0;i<18;i++){
        	 table.addCell(cellVerticalCenter(" ", dataFont));
             table.addCell(cellVerticalCenter(" ", dataFont));
             table.addCell(cellVerticalCenter(" ", dataFont));
             table.addCell(cellVerticalCenter(" ", dataFont));
             table.addCell(cellVerticalCenter(" ", dataFont));
             table.addCell(cellVerticalCenter(" ", dataFont));
             table.addCell(cellVerticalCenter(" ", dataFont));
             table.addCell(cellVerticalCenter(" ", dataFont));
        }
        
//        table.addCell(cellVerticalCenter("3.9", zhengwenFont));
        
//        table.addCell(new Paragraph("4.1", zhengwenFont));
        //gs3-3
        PdfPCell cell1 = new PdfPCell(new Phrase("总重量大写（克）：",zhengwenFont));
        cell1.setColspan(4);
        table.addCell(cell1);
   
        PdfPCell cell2 = new PdfPCell(new Phrase("证书数量大写（张）:",zhengwenFont));
        cell2.setColspan(5);
        table.addCell(cell2);
           
        document.add(table);
        
//       gs-4
		
		PdfPTable table2 = new PdfPTable(InitTable);
		table2.setWidthPercentage(100);
		table2.setSpacingBefore(7f);
		
		PdfPCell table2_cell_1_1 = new PdfPCell(new Phrase("委托方： ", zhengwenFont));
		table2_cell_1_1.setBorderColor(BaseColor.WHITE);
		table2_cell_1_1.setColspan(4);
		table2_cell_1_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table2_cell_1_1.setFixedHeight(20f);
		table2.addCell(table2_cell_1_1);
		
		PdfPCell table2_cell_1_2 = new PdfPCell(new Phrase("加工方：",zhengwenFont));
		table2_cell_1_2.setBorderColor(BaseColor.WHITE);
		table2_cell_1_2.setColspan(5);
		table2_cell_1_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table2_cell_1_2.setFixedHeight(20f);
		table2.addCell(table2_cell_1_2);
		

		PdfPCell table2_cell_2_1 = new PdfPCell(new Phrase("中国建设银行                       分行（盖章）", zhengwenFont));
		table2_cell_2_1.setBorderColor(BaseColor.WHITE);
		table2_cell_2_1.setColspan(4);
		table2_cell_2_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table2_cell_2_1.setFixedHeight(20f);
		table2.addCell(table2_cell_2_1);

		PdfPCell table2_cell_2_2 = new PdfPCell(new Phrase("公司（盖章）",zhengwenFont));
		table2_cell_2_2.setBorderColor(BaseColor.WHITE);
		table2_cell_2_2.setColspan(5);
		table2_cell_2_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table2_cell_2_2.setPaddingLeft(100f);
		table2_cell_2_2.setFixedHeight(20f);
		table2.addCell(table2_cell_2_2);
		
		
		PdfPCell table2_cell_3_1 = new PdfPCell(new Phrase("部  门：", zhengwenFont));
		table2_cell_3_1.setBorderColor(BaseColor.WHITE);
		table2_cell_3_1.setColspan(4);
		table2_cell_3_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table2_cell_3_1.setFixedHeight(20f);
		table2.addCell(table2_cell_3_1);

		PdfPCell table2_cell_3_2 = new PdfPCell(new Phrase("法定代表人或授权代理人签字：",zhengwenFont));
		table2_cell_3_2.setBorderColor(BaseColor.WHITE);
		table2_cell_3_2.setColspan(5);
		table2_cell_3_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table2_cell_3_2.setFixedHeight(20f);
//		table2_cell_3_2.setPaddingLeft(100f);
		table2.addCell(table2_cell_3_2);
		
		
		
		PdfPCell table2_cell_4_1 = new PdfPCell(new Phrase("授权代理人签字： ",zhengwenFont));
		table2_cell_4_1.setBorderColor(BaseColor.WHITE);
		table2_cell_4_1.setColspan(9);
		table2_cell_4_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table2_cell_4_1.setFixedHeight(20f);
		table2.addCell(table2_cell_4_1);
		
		
		PdfPCell table2_cell_5_1 = new PdfPCell(new Phrase("    年       月        日", zhengwenFont));
		table2_cell_5_1.setBorderColor(BaseColor.WHITE);
		table2_cell_5_1.setColspan(4);
		table2_cell_5_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table2_cell_5_1.setFixedHeight(20f);
		table2.addCell(table2_cell_5_1);

		PdfPCell table2_cell_5_2 = new PdfPCell(new Phrase("    年       月        日	",zhengwenFont));
		table2_cell_5_2.setBorderColor(BaseColor.WHITE);
		table2_cell_5_2.setColspan(5);
		table2_cell_5_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table2_cell_5_2.setFixedHeight(20f);
//		table2_cell_5_2.setPaddingLeft(100f);
		table2.addCell(table2_cell_5_2);
		
		
				
		document.add(table2);
		
				
		document.newPage();
					
//      gs-9
		String value6 = "说明：";
		Paragraph shuoming = new Paragraph(value6, songti);
		document.add(shuoming);			
		String value7 = "    1.填制《实物贵金属产品加工订货单》时，相关格式与内容不得修改调整，所有栏位要素必须填列完整；";
		Paragraph shuoming_1 = new Paragraph(value7, songti);
		document.add(shuoming_1);
		
		String value8 = "    2.“订货单编号”由9位数字构成：前4位代表订单年份，5-6位代表加工方编号，后3位代表一个自然年度内在该加工方的加工单序号；";
		Paragraph shuoming_2 = new Paragraph(value8, songti);
		document.add(shuoming_2);
		
		String value9 = "    3.委托方在委托加工方代为购买原料贵金属情况下，“订货单生效日”是指双方约定的原料具体购买日期；若原料贵金属由委托方提供，则“订货单生效日”由委托方与加工方共同商定；";
		Paragraph shuoming_3 = new Paragraph(value9, songti);
		document.add(shuoming_3);
		
		String value10 = "    4.加工方收到《实物贵金属产品加工订货单》后须签字、盖章，并回传给委托方予以确认。生效后的订货单，委托方和加工方须及时妥善保管备查。";
		Paragraph shuoming_4 = new Paragraph(value10, songti);
		document.add(shuoming_4);

        
        document.close();
		return false;
	} 
	

	/**
	 * @param value  表单单元格的值
	 * @param font   单元格中值的字体
	 * @return
	 */
	public static PdfPCell cellVerticalCenter(String value ,Font font){
        PdfPCell cell = new PdfPCell();
        Paragraph para = new Paragraph(value,font);
        cell.setPhrase(para);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		return cell;
	}
	

	
	 /**
	  * @Description 添加行内容
	  * @param document  文档对象
	  * @param list      行内容列表
	  * @return          返回添加行后的文档对象
	 * @throws DocumentException 
	  */
	 public static Document addParagraph(Document document,java.util.List<String> list,Font font) throws DocumentException{
		 for(String p : list){
			 document.add(new Paragraph(p,font));
		 }
		 return document;
	 }
	public static void main(String[] args) throws DocumentException, IOException {
		dealWithPdf();
		System.out.println("执行完毕了！！！");
	}
}
