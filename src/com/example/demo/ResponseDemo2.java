package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ļ�����
 * @author Administrator
 *
 */
public class ResponseDemo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		downloadFileByOutputStream(resp);
		downloadFileByPrintWriter(resp);
	}
	
	/**
	 * �����ļ���ͨ��OutputStream��
	 * @param response
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private void downloadFileByOutputStream(HttpServletResponse response) throws IOException,FileNotFoundException{
		//1����ȡҪ�����ļ��ľ���·��
		String realPath = this.getServletContext().getRealPath("/download/lena.jpg");
		//2����ȡҪ���ص��ļ���
		String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
		//3������content-disposition��Ӧͷ�ļ�������������ص���ʽ���ļ�
		response.setHeader("content-disposition", "attachment;filename="+fileName);
		//4����ȡҪ���ص������ļ���
		InputStream in = new FileInputStream(realPath);
		int len = 0;
		//5���������ݻ�����
		byte[] buffer = new byte[1024];
		//6��ͨ��response�����ȡOutputStream��
		OutputStream out = response.getOutputStream();
		//7����FileInputStream��д�뵽buffer������
		while((len = in.read(buffer)) > 0){
			//8��ʹ��OutputStream��������������������ͻ��������
			out.write(buffer,0,len);
		}
		in.close();
	}
	
    /**
     * �����ļ���ͨ��PrintWriter������ȻҲ�ܹ�ʵ�����أ����ǻᵼ�����ݶ�ʧ����˲��Ƽ�ʹ��PrintWriter�������ļ�
     * @param response
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void downloadFileByPrintWriter(HttpServletResponse response)
            throws FileNotFoundException, IOException {
        String realPath = this.getServletContext().getRealPath("/download/lena.jpg");//��ȡҪ���ص��ļ��ľ���·��
        String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);//��ȡҪ���ص��ļ���
        //����content-disposition��Ӧͷ��������������ص���ʽ���ļ��������ļ���Ҫʹ��URLEncoder.encode�������б���
        response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
        FileReader in = new FileReader(realPath);
        int len = 0;
        char[] buffer = new char[1024];
        PrintWriter out = response.getWriter();
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer,0,len);//��������������������ͻ��������
        }
        in.close();
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
