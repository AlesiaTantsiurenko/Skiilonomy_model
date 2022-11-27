

class Address(var country:String, var city:String, var house:Int){
  private var _country:String = country;
  private var _city:String = city;
  private var _house:Int = house;
  override def toString(): String = s"${_country}, ${_city}, ${_house}";
  def Country:String = _country;
  def Country_=(newValue:String) = {
    _country=newValue;
  }
    def City:String = _city;
  def City_=(newValue:String) = {
    _city=newValue;
  }
    def House:Int = _house;
  def House_=(newValue:Int) = {
    _house=newValue;
  }
 
}