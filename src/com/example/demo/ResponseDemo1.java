package com.example.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 4312868947607181532L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		outputChineseByOutputStream(resp);//ʹ��OutputStream���������
	}
	
	/**
	 * ʹ��OutputStream���������
	 * @param response
	 * @throws IOException
	 */
	
	public void outputChineseByOutputStream(HttpServletResponse response)throws IOException{
		/**
		 *ʹ��OutputStream�������ע������
		 *�ڷ������ˣ����������ĸ��������ģ���ô��Ҫ���ƿͻ������������Ӧ�����򿪣�
		 *���磺outputStream��write("�й�".getBytes("UTF-8"));//��UTF-8����ʹ��OutputStream����ͻ���������ģ�
		 *��Ҫ��UTF-8��ʽ�������������ͻ������������
		 *����ͨ������ͷ�������������Ϊ��
		 *response.setHeader("content-type","text/html;charset=UTF-8")
		 */
		String data = "�й�";
		OutputStream outputStream = response.getOutputStream();//��ȡOutputStream�����
//		response.setHeader("content-type", "text/html;charset=UTF-8");
		/**
		 * data.getBytes()��һ�����ַ���ת��Ϊ�ֽ�����Ĺ��̣��������һ����ȥ�����
		 * ��������ĵĲ���ϵͳ������Ĭ�Ͼ��ǲ��Ҳ�GB2312�����
		 * ���ַ�ת�����ֽ�����Ĺ��̾��ǽ������ַ�ת����GB2312������϶�Ӧ������
		 * ���磺 "��"��GB2312������϶�Ӧ��������98��"��"��GB2312������϶�Ӧ��������99
		 * getBytes()�������������������ô�ͻ���ݲ���ϵͳ�����Ի�����ѡ��ת�������������Ĳ���ϵͳ����ô��ʹ��GB2312�����
		 */
		byte[] dataByteArr = data.getBytes("UTF-8");
		outputStream.write(dataByteArr);		
	}
	
	public void outputChinesePrintWriter(HttpServletResponse response)throws IOException{
		String data = "�й�";
		
		//ͨ��������Ӧͷ�����������UTF-8�ı�����ʾ���ݣ����������仰����ô�������ʾ�Ľ�������
		//response.setHeader("content-type", "text/html;charset=UTF-8");
		
//		response.setCharacterEncoding("UTF-8");//���ý��ַ���"UTF-8"����������ͻ��������
		/**
         * PrintWriter out = response.getWriter();������������response.setCharacterEncoding("UTF-8");֮��
         * ����response.setCharacterEncoding("UTF-8")���д�������ý���Ч���������ʾ��ʱ��������
         */
        PrintWriter out = response.getWriter();//��ȡPrintWriter�����
        
        /**
         * ��ѧһ�У�ʹ��HTML���������<meta>��ǩ�������������Ϊ��ģ��ͨ��������Ӧͷ�����������Ϊ
         * out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
         * ��ͬ��response.setHeader("content-type", "text/html;charset=UTF-8");
         */
        out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
        out.write(data);//ʹ��PrintWriter����ͻ�������ַ�
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
//		doGet(req, resp);
	}

}
