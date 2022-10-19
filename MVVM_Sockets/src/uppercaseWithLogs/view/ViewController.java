package uppercaseWithLogs.view;

import uppercaseWithLogs.core.ViewHandler;
import uppercaseWithLogs.core.ViewModelFactory;

public interface ViewController
{
  void init(ViewHandler vh, ViewModelFactory vmf);
}
