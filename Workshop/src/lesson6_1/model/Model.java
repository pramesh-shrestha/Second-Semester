package lesson6_1.model;

import lesson6_1.util.PropertyChangeSubject;

import java.util.ArrayList;

public interface Model extends PropertyChangeSubject
{
  String convert(String source) throws Exception;
  void addLog(String log);
  ArrayList<String> getLogs();

}
