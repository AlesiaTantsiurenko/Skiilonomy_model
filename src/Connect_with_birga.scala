

trait Connect_with_birga {
  def sell(tokens_to_sell:Double, birga:Birga, balance:Double, fiat:Double):Tuple2[Double, Double] = {
    for(i<-0 until tokens_to_sell.toInt){
    var new_price = birga.get_price - 0.01;
    birga.set_price(new_price);}
    var new_balance_birga_tokens = birga.get_amount_tokens + tokens_to_sell;
    birga.set_amount_tokens(new_balance_birga_tokens);
    var new_balance_person_tokens = balance - tokens_to_sell;
    var new_balance_person_fiat = fiat + (birga.get_price*tokens_to_sell);
     var new_balance_birga_fiat = birga.get_amount_fiat - (birga.get_price*tokens_to_sell);
    birga.set_amount_fiat(new_balance_birga_fiat);
    return (new_balance_person_tokens, new_balance_person_fiat)
  }
  def buy(needs_tokens:Double, birga:Birga, balance:Double, fiat:Double):Tuple2[Double, Double] = {
    for(i<-0 until needs_tokens.toInt){
    var new_price = birga.get_price + 0.01;
    birga.set_price(new_price);}
    var new_balance_birga_tokens = birga.get_amount_tokens - needs_tokens;
    birga.set_amount_tokens(new_balance_birga_tokens);
    var new_balance_person_tokens = balance + needs_tokens;
    var new_balance_person_fiat = fiat - (birga.get_price*needs_tokens);
     var new_balance_birga_fiat = birga.get_amount_fiat + (birga.get_price*needs_tokens);
    birga.set_amount_fiat(new_balance_birga_fiat);
    return (new_balance_person_tokens, new_balance_person_fiat)
  }
}