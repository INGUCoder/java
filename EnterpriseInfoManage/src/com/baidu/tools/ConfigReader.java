package com.baidu.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
/**
 * ��������ȡ������
 *
 */
public class ConfigReader {
     
    /**
     * ����ini������
     */
    private Map<String,Map<String, List<String>>>  map = null;
    /**
     * ��ǰSection������
     */
    private String currentSection = null;
     
    /**
     * ��ȡ
     * @param path
     */
    public ConfigReader(String path) {
        map = new HashMap<String, Map<String,List<String>>>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            read(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("IO Exception:" + e);
        }
         
    }
 
    /**
     * ��ȡ�ļ�
     * @param reader
     * @throws IOException
     */
    private void read(BufferedReader reader) throws IOException {
        String line = null;
        while((line=reader.readLine())!=null) {
            parseLine(line);
        }
    }
     
    /**
     * ת��
     * @param line
     */
    private void parseLine(String line) {
        line = line.trim();
        // �˲���Ϊע��
        if(line.matches("^\\#.*$")) {
            return;
        }else if (line.matches("^\\[\\S+\\]$")) {
            // section
            String section = line.replaceFirst("^\\[(\\S+)\\]$","$1");
            addSection(map,section);
        }else if (line.matches("^\\S+=.*$")) {
            // key ,value
            int i = line.indexOf("=");
            String key = line.substring(0, i).trim();
            String value =line.substring(i + 1).trim();
            addKeyValue(map,currentSection,key,value);
        }
    }
 
 
    /**
     * �����µ�Key��Value
     * @param map
     * @param currentSection
     * @param key
     * @param value
     */
    private void addKeyValue(Map<String, Map<String, List<String>>> map,
            String currentSection,String key, String value) {
        if(!map.containsKey(currentSection)) {
            return;
        }
         
        Map<String, List<String>> childMap = map.get(currentSection);
         
        if(!childMap.containsKey(key)) {
            List<String> list = new ArrayList<String>();
            list.add(value);
            childMap.put(key, list);
        } else {
            childMap.get(key).add(value);
        }
    }
 
 
    /**
     * ����Section
     * @param map
     * @param section
     */
    private void addSection(Map<String, Map<String, List<String>>> map,
            String section) {
        if (!map.containsKey(section)) {
            currentSection = section;
            Map<String,List<String>> childMap = new HashMap<String, List<String>>();
            map.put(section, childMap);
        }
    }
     
    /**
     * ��ȡ�����ļ�ָ��Section��ָ���Ӽ���ֵ
     * @param section
     * @param key
     * @return
     */
    public List<String> get(String section,String key){
        if(map.containsKey(section)) {
            return  get(section).containsKey(key) ?
                    get(section).get(key): null;
        }
        return null;
    }
     
    /**
     * ��ȡ�����ļ�ָ��Section���Ӽ���ֵ
     * @param section
     * @return
     */
    public Map<String, List<String>> get(String section){
        return  map.containsKey(section) ? map.get(section) : null;
    }
     
    /**
     * ��ȡ��������ļ��Ľڵ��ֵ
     * @return
     */
    public Map<String, Map<String, List<String>>> get(){
        return map;
    }
     
}