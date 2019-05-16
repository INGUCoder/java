package com.svideo.until;

import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class PluploadService {
    public static void upload(Plupload plupload,
                              File pluploadDir, HttpSession session) {
        UUID uuid = UUID.randomUUID();
        String[] fileNames = plupload.getName().split("\\.");
        String fileName = uuid.toString() + "." + fileNames[1];//�ڷ�����������Ψһ�ļ�
        upload(plupload, pluploadDir, fileName);
    }

    public static void upload(Plupload plupload, File pluploadDir, String fileName) {

        int chunks = plupload.getChunks();//�û��ϴ��ļ����ָ����ܿ���
        int nowChunk = plupload.getChunk();//��ǰ�飬��0��ʼ

        //����Request�������͵�ǿ��ת�����ܳ��������ļ�����SpringIOC��������multipartResolver���󼴿ɡ�
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) plupload.getRequest();
        //���Է���map��ֻ��һ����ֵ��
        MultiValueMap map = multipartHttpServletRequest.getMultiFileMap();

        if (map != null) {
            try {
                Iterator iterator = map.keySet().iterator();
                while (iterator.hasNext()) {

                    String key = (String) iterator.next();
                    List<MultipartFile> multipartFileList = (List<MultipartFile>) map.get(key);

                    for (MultipartFile multipartFile : multipartFileList) {//ѭ��ֻ����һ��

                        plupload.setMultipartFile(multipartFile);//�ֶ���Plupload������MultipartFile����ֵ
                        File targetFile = new File(pluploadDir + "/" + fileName);//�½�Ŀ���ļ���ֻ�б���д��ʱ�Ż���������
                        if (chunks > 1) {//�û��ϴ������ܿ�������1��Ҫ���кϲ�

                            File tempFile = new File(pluploadDir.getPath() + "/" + multipartFile.getName());
                            //��һ��ֱ�Ӵ�ͷд�룬���ô�ĩ��д��
                            savePluploadFile(multipartFile.getInputStream(), tempFile, nowChunk == 0 ? false : true);

                            if (chunks - nowChunk == 1) {//ȫ�����Ѿ��ϴ���ϣ���ʱtargetFile��Ϊ�б���д������ڣ�Ҫ���ļ�����
                                tempFile.renameTo(targetFile);
                            }
                        } else {
                            //ֻ��һ�飬��ֱ�ӿ����ļ�����
                            multipartFile.transferTo(targetFile);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void savePluploadFile(InputStream inputStream, File tempFile, boolean flag) {
        OutputStream outputStream = null;
        try {
            if (flag == false) {
                //��ͷд��
                outputStream = new BufferedOutputStream(new FileOutputStream(tempFile));
            } else {
                //��ĩ��д��
                outputStream = new BufferedOutputStream(new FileOutputStream(tempFile, true));
            }
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = (inputStream.read(bytes))) > 0) {
                outputStream.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
