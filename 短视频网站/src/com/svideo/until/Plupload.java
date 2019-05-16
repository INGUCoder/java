package com.svideo.until;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Pluploadʵ����̶���ʽ�������������޸�
 * ��ΪMultipartFileҪ�õ�Spring web������������������webģ���в����룬���Բ��Ѹ�ʵ�������entityģ��
 */
public class Plupload {
    /**
     * �ļ�ԭ��
     */
    private String name;
    /**
     * �û��ϴ����ϱ��ֽ��ܿ���
     */
    private int chunks = -1;
    /**
     * ��ǰ��������0��ʼ������
     */
    private int chunk = -1;
    /**
     * HttpServletRequest���󣬲����Զ���ֵ����Ҫ�ֶ�����
     */
    private HttpServletRequest request;
    /**
     * �����ļ��ϴ���Ϣ�������Զ���ֵ����Ҫ�ֶ�����
     */
    private MultipartFile multipartFile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChunks() {
        return chunks;
    }

    public void setChunks(int chunks) {
        this.chunks = chunks;
    }

    public int getChunk() {
        return chunk;
    }

    public void setChunk(int chunk) {
        this.chunk = chunk;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}  