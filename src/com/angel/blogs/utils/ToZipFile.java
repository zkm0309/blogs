package com.angel.blogs.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jxl.CellView;
import jxl.Workbook;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ToZipFile {
	/**
	 * 
	 * @param fileName
	 *            文件名
	 * @param list
	 *            数据
	 * @param request
	 * @param length
	 *            每个文件长度
	 * @param out
	 *            输出流
	 * @param tatel
	 *            标题
	 * @param tatelcodek
	 *            跨行的列
	 * @param tatelcode
	 *            所有列
	 * @throws IOException
	 */
	public String toExcel(String fileName, List<Map<String, Object>> list, HttpServletRequest request,

			int length, OutputStream out, String[] tatel, Map<String, String> tatelcodek, String[] tatelcode)
			throws IOException {
		String pathx = request.getRealPath("/excel") + "导出文件" + ".zip";
		try {
			List<String> fileNames = new ArrayList<String>();// 用于存放生成的文件名称s
			File zip = new File(pathx);// 压缩文件
			String wsk = fileName;
			int xb = 0;
			for (int j = 0, n = list.size() / length + 1; j < n; j++) {
				fileName = wsk + (j + 1) + ".xls";
				fileNames.add(fileName);
				OutputStream os = new FileOutputStream(fileName);
				WritableWorkbook wwb = Workbook.createWorkbook(os);
				WritableSheet ws = wwb.createSheet(fileName, 0);
				// 格式化
				WritableFont wfc = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false,
						UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
				// 内容
				WritableFont contentWfc = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
						UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
				WritableCellFormat wcfFC = new WritableCellFormat(wfc);
				wcfFC.setWrap(true);
				wcfFC.setAlignment(Alignment.CENTRE); // 水平居中
				wcfFC.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直居中
				wcfFC.setBorder(Border.ALL, BorderLineStyle.THIN); // 边框颜色
				// 内容
				WritableCellFormat contentWcfFC = new WritableCellFormat(contentWfc);
				contentWcfFC.setWrap(true);
				contentWcfFC.setAlignment(Alignment.CENTRE); // 水平居中
				contentWcfFC.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直居中
				contentWcfFC.setBorder(Border.ALL, BorderLineStyle.THIN);
				CellView navCellView = new CellView();
				navCellView.setAutosize(true); // 设置自动大小
				navCellView.setSize(18);
				/*ws.setColumnView(j, 18);*/
				/** 视觉效果不好看时，还可根据实际情况，增加长度例如： */
				/*ws.setColumnView(0,ws.getCell(0,j).getContents().length()*2+6);*/
				ws.setRowView(0, 1000, false); // 设置行高
				for (int r = 0; r < tatel.length; r++) {
					ws.addCell(new Label(r, 0, tatel[r], wcfFC));
					//设置列宽
					ws.setColumnView(r,ws.getCell(r,j).getContents().length()*2+10);
				}
				int sy = length;
				int m = 0;
				for (int k = 1; k <= length; k++) {
					if (xb >= list.size()) {
						// 写入完成结束本个文件的写入
						break;
					}
					Integer rowspanNum = 0; // 跨列数
					
//					try {
//						rowspanNum = Integer.parseInt(list.get(xb).get("ZONGSHU").toString());
//					} catch (NumberFormatException e) {
//						rowspanNum = 0;
//					}
					
					Map<String, Object> user = list.get(xb);
					if (xb >= list.size() || (sy < rowspanNum)) {
						// 剩余行不足跨列时结束本个文件的写入
						break;
					}
					for (int r = 0; r < tatelcode.length; r++) {
						ws.addCell(new Label(r, k,
								user.get(tatelcode[r]) == null ? "" : user.get(tatelcode[r]).toString(), contentWcfFC));
						
//						if (tatelcodek.get(tatelcode[r]) != null && "1".equals(user.get("ISROWSPAN") + "")) {
//							ws.mergeCells(r, m + 1, r, m + rowspanNum);
//						}
						
						if (tatelcodek.get(tatelcode[r]) != null) {
							ws.mergeCells(r, m + 1, r, m + rowspanNum);
						}
						
					}
					m++;
					sy--;
					xb++;
				}
				wwb.write();
				wwb.close();
				os.close();
			}
			File srcfile[] = new File[fileNames.size()];
			for (int i = 0, n = fileNames.size(); i < n; i++) {
				srcfile[i] = new File(fileNames.get(i));

			}
			FileZip.ZipFiles(srcfile, zip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pathx;
	}
}
