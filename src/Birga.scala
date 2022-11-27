

class Birga {
  private var _amount_tokens:Double = 100000;
  private var _amount_fiat:Double = 100000;
  private var _price:Double = 1.0;
  override def toString(): String = super.toString() + s", ${_amount_tokens}" + s", ${_amount_fiat}" + s", ${_price}";
  def Show(): String =  s"\nAmount tokens: ${_amount_tokens}\n" + s"Amount fiat: ${_amount_fiat}\n" + s"Price_token: ${_price}\n";
  def get_amount_tokens:Double = _amount_tokens;
  def set_amount_tokens(NewValue:Double) = {
    _amount_tokens = NewValue;
  }
  def get_amount_fiat:Double = _amount_fiat;
  def set_amount_fiat(NewValue:Double) = {
    _amount_fiat = NewValue;
  }
  def get_price:Double = _price;
  def set_price(NewValue:Double) = {
    _price = NewValue;
  }
  
}