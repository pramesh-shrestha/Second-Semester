package ex2_WriterPreference;

public interface ReadWrite
{
  void acquireRead();	// some condition
  void releaseRead();
  void acquireWrite(); // some other condition
  void releaseWrite();
}
