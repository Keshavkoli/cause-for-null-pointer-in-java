package com.excelservlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ObjectUtils;

import com.dao.HRQestionDao;
import com.excelpojo.ExcelCellModel;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;

import io.github.millij.poi.ss.reader.XlsReader;

@WebServlet("/HrUploadExcelFile")
@MultipartConfig(maxFileSize = 52428800L)
public class ExcelFileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcelFileUpload() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.print("<h1> Entered into Excel file<h1>");
		Part filePart = request.getPart("filePath");
		System.out.println(":filePart:==>" + filePart);

		String fileName = this.getFileName(filePart);
		String ext = FilenameUtils.getExtension(fileName);
		System.out.println(":ext:==>" + ext);
		InputStream inputStream = filePart.getInputStream();
		System.out.println(":is:==>" + inputStream.toString());

//		readExcelFile(is);

	

		List<ExcelCellModel> pojoExcel = null;
		XlsReader reader = new XlsReader();
		try {
			pojoExcel = Poiji.fromExcel(inputStream, PoijiExcelType.XLSX, ExcelCellModel.class);
			System.out.println(":pojoExcel:==>" + pojoExcel.get(0).getEmailId());
			System.out.println(":pojoExcel:==>" + pojoExcel.get(1).getLoginName());
			System.out.println(":pojoExcel:==>" + pojoExcel.get(2).getLoginId());
			HttpServletResponse response1 = null;
			PrintWriter p = response1.getWriter();
					p.println(pojoExcel + "\t\t");
//			System.out.print(cellValue + "\t\t");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<ExcelCellModel> excelList = new ArrayList<ExcelCellModel>();
		if (ObjectUtils.isNotEmpty(pojoExcel)) {
			for (ExcelCellModel ecm : pojoExcel) {
				ExcelCellModel excelCellModel = new ExcelCellModel();
				if (ObjectUtils.isNotEmpty(ecm.getBranchCode())) {
					excelCellModel.setBranchCode(ecm.getBranchCode());
				}
				if (ObjectUtils.isNotEmpty(ecm.getEmailId()) && isValidEmail(ecm.getEmailId())) {
					excelCellModel.setEmailId(ecm.getEmailId());
				}
				if (ObjectUtils.isNotEmpty(ecm.getLoginName())) {
					excelCellModel.setLoginName(ecm.getLoginName());
				}
				if (ObjectUtils.isNotEmpty(ecm.getCluster())) {
					excelCellModel.setCluster(ecm.getCluster());
				}
				if (ObjectUtils.isNotEmpty(ecm.getEmpCode())) {
					excelCellModel.setEmpCode(ecm.getEmpCode());
				}
				if (ObjectUtils.isNotEmpty(ecm.getLoginId())) {
					excelCellModel.setLoginId(ecm.getLoginId());
				}
				if (ObjectUtils.isNotEmpty(ecm.getZone())) {
					excelCellModel.setZone(ecm.getZone());
				}
				if (ObjectUtils.isNotEmpty(ecm.getUserCode())) {
					excelCellModel.setUserCode(ecm.getUserCode());
				}
				excelList.add(excelCellModel);
			}

		}

//		out.print(excelCellModel);
//		int insertRecords = 0;
		try {
			final boolean success = HRQestionDao.insertRecords(excelList);
			String url;
			if (success) {
				System.out.println("Dat");
			} else {
				System.out.println("Data saved successfully");

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private String getFileName(final Part part) {
		final String contentDisp = part.getHeader("content-disposition");
		final String[] tokens = contentDisp.split(";");
		String[] array;
		for (int length = (array = tokens).length, i = 0; i < length; ++i) {
			final String token = array[i];
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}

	public boolean isValidEmail(String email) {
//        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		String ePattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

}
