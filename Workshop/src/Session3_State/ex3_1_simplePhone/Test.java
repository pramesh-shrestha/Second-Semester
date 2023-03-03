package Session3_State.ex3_1_simplePhone;

public class Test {
  public static void main(String[] args) {
    Phone phone = new Phone(new Silent());
    phone.onClick();
    phone.onMessage("asd");
  }

}
