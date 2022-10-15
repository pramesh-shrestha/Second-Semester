package ex3_UppercaseTwoViews.model;

import java.util.ArrayList;
import java.util.List;

public interface TextConverter
{
   String toUppercase(String  text);
   void addLog(String log);
   ArrayList<String> getLog();
}
