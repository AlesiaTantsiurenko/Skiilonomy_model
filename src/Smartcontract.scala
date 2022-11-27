

class Smartcontract(var profit:Int, var period:Int, var percentage_part:Int){
  private var _profit:Int = profit;
  private var _period:Int = period;
  private var _percentage_part:Int = percentage_part;
  override def toString(): String = s"Прибыль: ${_profit}, Период обучения: ${_period}, Процентная часть вознограждения: ${_percentage_part}";
  def Profit:Int = _profit;
  def Profit(newValue:Int) = {
    _profit=newValue;
  }
    def Period:Int = _period;
  def Period(newValue:Int) = {
    _period=newValue;
  }
    def Percentage_part:Int = _percentage_part;
  def Percentage_part(newValue:Int) = {
    _percentage_part=newValue;
  }
 

}