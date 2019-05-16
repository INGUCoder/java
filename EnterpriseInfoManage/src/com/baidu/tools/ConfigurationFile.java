package com.baidu.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ConfigurationFile {
    /**
     * ��ini�����ļ��ж�ȡ������ֵ
     *
     * @param file         �����ļ���·��
     * @param section      Ҫ��ȡ�ı������ڶ�����
     * @param variable     Ҫ��ȡ�ı�������
     * @param defaultValue �������Ʋ�����ʱ��Ĭ��ֵ
     * @return ������ֵ
     * @throws IOException �׳��ļ��������ܳ��ֵ�io�쳣
     */
	public static String read(String location,String key,String flag) throws IOException{
		File file = new File(location);
		if(!file.exists()){
			return null;
		}
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = br.readLine())!= null){
			int a = line.length();
			int b = key.length();
			int c = flag.length();
			if(a>b&&line.substring(0,b).equals(key)&&a-b>=c&&(line.substring(b,b+c).equals(flag))){
				String s = line.substring(b+c);
				br.close();
				System.out.println(s);
				return s;
			}
		}
		br.close();
		return null;
	}
	
    public static String readCfgValue(String file, String section, String variable, String defaultValue) throws IOException {
        String strLine, value = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        boolean isInSection = false;
        try {
            while ((strLine = bufferedReader.readLine()) != null) {
                strLine = strLine.trim();
                strLine = strLine.split("[;]")[0];
                Pattern p;
                Matcher m;
                p = Pattern.compile("\\[\\w+]");//Pattern.compile("file://[//s*.*//s*//]");
                m = p.matcher((strLine));
                if (m.matches()) {
                    p = Pattern.compile("\\[" + section + "\\]");//Pattern.compile("file://[//s*" + section + "file://s*//]");
                    m = p.matcher(strLine);
                    if (m.matches()) {
                        isInSection = true;
                    } else {
                        isInSection = false;
                    }
                }
                if (isInSection == true) {
                    strLine = strLine.trim();
                    String[] strArray = strLine.split("=");
                    if (strArray.length == 1) {
                        value = strArray[0].trim();
                        if (value.equalsIgnoreCase(variable)) {
                            value = "";
                            return value;
                        }
                    } else if (strArray.length == 2) {
                        value = strArray[0].trim();
                        if (value.equalsIgnoreCase(variable)) {
                            value = strArray[1].trim();
                            return value;
                        }
                    } else if (strArray.length > 2) {
                        value = strArray[0].trim();
                        if (value.equalsIgnoreCase(variable)) {
                            value = strLine.substring(strLine.indexOf("=") + 1).trim();
                            return value;
                        }
                    }
                }
            }
        } finally {
            bufferedReader.close();
        }
        return defaultValue;
    }

    /**
     * �޸�ini�����ļ��б�����ֵ
     *
     * @param file     �����ļ���·��
     * @param section  Ҫ�޸ĵı������ڶ�����
     * @param variable Ҫ�޸ĵı�������
     * @param value    ��������ֵ
     * @throws IOException �׳��ļ��������ܳ��ֵ�io�쳣
     */
    public static boolean writeCfgValue(String file, String section, String variable, String value) throws IOException {
        String fileContent, allLine, strLine, newLine, remarkStr = "";
        String getValue = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        boolean isInSection = false;
        boolean canAdd = true;
        fileContent = "";
        try {

            while ((allLine = bufferedReader.readLine()) != null) {
                allLine = allLine.trim();
                strLine = allLine.split(";")[0];
                Pattern p;
                Matcher m;
                p = Pattern.compile("\\[\\w+]");
                m = p.matcher((strLine));
                if (m.matches()) {
                    p = Pattern.compile("\\[" + section + "\\]");
                    m = p.matcher(strLine);
                    if (m.matches()) {
                        isInSection = true;
                    } else {
                        isInSection = false;
                    }
                }
                if (isInSection == true) {
                    strLine = strLine.trim();
                    String[] strArray = strLine.split("=");
                    getValue = strArray[0].trim();
                    if (getValue.equalsIgnoreCase(variable)) {
                        newLine = getValue + "=" + value;
                        fileContent += newLine;
                        while ((allLine = bufferedReader.readLine()) != null) {
                            fileContent += "\r\n" + allLine;
                        }
                        bufferedReader.close();
                        canAdd = false;
                        System.out.println(fileContent);
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                        bufferedWriter.write(fileContent);
                        bufferedWriter.flush();
                        bufferedWriter.close();

                        return true;
                    }

                }
                fileContent += allLine + "\r\n";
            }
            if (canAdd) {
                String str = variable + "=" + value;
                fileContent += str + "\r\n";
                System.out.println(fileContent);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                bufferedWriter.write(fileContent);
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            bufferedReader.close();
        }
        return false;
    }
}