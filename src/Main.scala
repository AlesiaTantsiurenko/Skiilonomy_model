import scala.collection.mutable.ListBuffer

object Main {
  def main(args: Array[String]){
    println("Hello, world");
    var addr1 = new Address("Ukraine", "Kherson", 18);
    var addr2 = new Address("Ukraine", "Kherson", 2);
    var addr3 = new Address("Ukraine", "Kherson", 18);
    var smartcontract_1 = new Smartcontract(500, 6, 10);
    var smartcontract_2 = new Smartcontract(500, 10, 5);
    var h1 = new Teacher("Natalia", "Vinnikova", 34, "natvin@gmail.com", addr1, "Natalia", "12345", 0, 1000, smartcontract_1, 5);
    var s1 = new Student("Lisa", "Laferova", 17, "lislaf@gmail.com", addr2, "Lisa", "123", 0, 1000, smartcontract_1);
    var s2 = new Student("Marta", "Zarova", 18, "marta@gmail.com", addr3, "Marta", "456", 0, 1000, smartcontract_1);
     var s3 = new Student("Viktor", "Tritakov", 18, "viktor@gmail.com", addr3, "Viktor", "456", 0, 1000, smartcontract_1);
    var s4 = new Student("Lisa", "Krasnova", 18, "lisa@gmail.com", addr3, "Lisa", "456", 0, 1000, smartcontract_1);
    var s5 = new Student("Nikita", "Vasilkov", 18, "nikita@gmail.com", addr3, "Nikita", "456", 0, 1000, smartcontract_1);
    var s6 = new Student("Daria", "Novikova", 18, "daria@gmail.com", addr3, "Daria", "456", 0, 1000, smartcontract_1);
    var s7 = new Student("Simon", "Listrov", 18, "simon@gmail.com", addr3, "Simon", "456", 0, 1000, smartcontract_1);
    var s8 = new Student("Veronika", "Krivzova", 18, "veronika@gmail.com", addr3, "Veronika", "456", 0, 1000, smartcontract_1);
    var s9 = new Student("Mikhail", "Kotov", 18, "mikhail@gmail.com", addr3, "Mikhail", "456", 0, 1000, smartcontract_1);
    var s10 = new Student("Rita", "Naumova", 18, "rita@gmail.com", addr3, "Rita", "456", 0, 1000, smartcontract_1);
    var birga = new Birga();
    var platform = new Platform();
    h1.addinlist(s1);
    h1.addinlist(s2);
    h1.addinlist(s3);
    h1.addinlist(s4);
    h1.addinlist(s5);
    h1.addinlist(s6);
    h1.addinlist(s7);
    h1.addinlist(s8);
    h1.addinlist(s9);
    h1.addinlist(s10);
    
    println(h1.Show());
    println(h1.showlist());
    h1.evaluation(birga, platform);
    println(h1.Show());
    println(h1.showlist());
    
   /*s1.buy(10, birga, s1.balance, s1.fiat);
    println(birga.toString());
    h1.sell(5, birga, h1.balance, h1.fiat);*/
    println(birga.Show());
    println(platform.Show());}
}