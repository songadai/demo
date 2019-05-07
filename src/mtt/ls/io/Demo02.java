package mtt.ls.io;



import java.io.*;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月07天，劉松创建。
 *
 *
 * 读入和写出文件
 */
public class Demo02
{

    /*
     * @Author 刘松
     * @Date 9:31 2019/5/7
     * @Description
     
     * @param: null
     
     * @Return
     */       
                   
    public static void main(String[] args)
    {
      //  testread();
        testwriter();
    }

    /**
     * 一、读入文件
     * 1.获取源头
     * 2.选择流
     * 3.进行操作，使用byte[] car数组进行接收
     * 4.释放资源
     */
    public static void testread()
    {
       //选择源头
        File source = new File("1.txt");
        //选择流
        InputStream is=null;
        try
        {
            is=new FileInputStream(source);
            byte[] car = new byte[100];
            int len=0;
            while (-1!=(len=is.read(car))){
                String s = new String(car, 0, len);
                System.out.println(s);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if(is!=null){
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }


    }
    /**
     * 一、写入文件
     * 1.选择源
     * 2.选择流
     * 3.操作
     */
    public static void testwriter(){
        File file = new File("2.txt");
        OutputStream os=null;
        try
        {
            os=new FileOutputStream(file,true);
            String str="hahah niniubi";
            byte[] bytes = str.getBytes();
            os.write(bytes,0,str.length());
            os.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if(os!=null){
                try
                {
                    os.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

}
