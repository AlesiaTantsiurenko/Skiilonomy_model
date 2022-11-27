

class Student(name:String, surname:String, age:Int, email:String, addr:Address, var login:String, var password:String, var balance:Double, var fiat:Double, var smartcontract:Smartcontract) extends Human(name, surname, age, email, addr) with  Connect_with_birga{
  private var _login:String = login;
  private var _password:String = password;
  private var _balance:Double = balance;
  private var _fiat:Double = fiat;
  private var _smartcontract:Smartcontract = smartcontract;
  override def toString(): String = super.toString() +  s", ${_balance}" + s", ${_fiat}"+ s", ${_smartcontract}";
  override def Show(): String = super.Show() + s"\nBalance: ${_balance}\n" + s"\nFiat: ${_fiat}\n" + s"Smartcontract: ${_smartcontract.toString()}\n";

  
  
  def Login:String = _login;
  def Login(newValue:String) = {
    _login=newValue;
  }
  def Password:String = _password;
  def Password(newValue:String) = {
    _password=newValue;
  }
  def Balance:Double = _balance;
  def set_balance(newValue:Double, birga:Birga, platform:Platform, courseprice:Int) = {
    if(newValue<0){
      var reserv = newValue.abs;
      var toup:Tuple2[Double, Double] = buy(reserv, birga, _balance, _fiat);
      _balance=toup._1;
        _fiat=toup._2;
    }
    else{
    _balance=newValue;
    }
  }
  def Fiat:Double = _fiat;
  def set_fiat(newValue:Double) = {
    _fiat=newValue;
  }
  def Smartcontract:Smartcontract = _smartcontract;
  def Smartcontract(newValue:Smartcontract) = {
    _smartcontract=newValue;
  }
}