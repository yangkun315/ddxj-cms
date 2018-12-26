package net.zn.ddxj.demo;import net.zn.ddxj.demo.FtpGetTest;import com.dcfs.esb.ftp.client.https.FtpGet;import com.dcfs.esb.ftp.server.msg.FileMsgBean;import com.pabank.sdk.PABankSDK;public class FtpGetTest {	public void test(String remoteFile, String localFile, String privateAuth) {		FtpGet ftpGet = null;		FileMsgBean bean = null;		try {			// 初始化配置			PABankSDK.init("conf/config.properties");			// 验证开发者			PABankSDK.getInstance().approveDev();			bean = new FileMsgBean();			/**			 * FtpGet类的构造器使用说明 ;			 * 参数一:remoteFile： 服务器文件名，由文件上传方提供，如"/picp/报价单.txt";			 * 参数二:localFile:下载文件时，需指定一个本机的绝对路径存放下载后的文件（文件名也要指定），如"D:/download.txt";			 * 参数三:scrtFlag ： 是否加密标志，填false ;			 * 参数四:key： 加密密钥，填null ;			 * 参数五:privateAuth： 提取码，由文件上传方提供。每个文件都有对应的提取码，提取码错误将无法下载文件 ;			 * 参数六:bean：消息bean， 用于获取服务器响应的消息.			 * */			ftpGet = new FtpGet(remoteFile, localFile, false, null, privateAuth, bean);			//文件上传			ftpGet.doGetFile();		} catch (Exception e) {			// 捕获到异常后，可以从FileMsgBean类获取异常信息			System.out.println(bean.getFileRetMsg());			e.printStackTrace();		} finally {			if (null != ftpGet) {				ftpGet.close(true);			}		}	}	public static void main(String[] args) {		//文件下载方法调用		new FtpGetTest().test("/H22285/upload.txt", "D:/download.txt","4a3990a8-7fe0-454d-8146-a448915d0f37");	}}