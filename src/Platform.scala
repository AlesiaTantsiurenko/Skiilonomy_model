

class Platform extends Connect_with_birga {
  private var _amount_tokens:Double = 100000;
  private var _fiat:Double = 100000;
  override def toString(): String = super.toString() + s", ${_amount_tokens}" + s", ${_fiat}" ;
  def Show(): String =  s"\nAmount tokens: ${_amount_tokens}\n" + s"Fiat: ${_fiat}\n";
  def get_amount_tokens:Double = _amount_tokens;
  def set_amount_tokens(NewValue:Double) = {
    _amount_tokens = NewValue;
  }
  def get_fiat:Double = _fiat;
  def set_fiat(NewValue:Double) = {
    _fiat = NewValue;
  }
}