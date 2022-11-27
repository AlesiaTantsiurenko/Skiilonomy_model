

trait Connect_with_platform {
  def give(platform:Platform, price:Double){
    var newValue = platform.get_amount_tokens - price;
    platform.set_amount_tokens(newValue);
  }
  def get(platform:Platform, corseprice:Int){
    var newValue = platform.get_amount_tokens + (corseprice/2);
    platform.set_amount_tokens(newValue);
  }
}