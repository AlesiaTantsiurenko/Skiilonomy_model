import scala.collection.mutable.ListBuffer
import scala.util.Random
class Teacher(name:String, surname:String, age:Int, email:String, addr:Address, var login:String, var password:String, var balance:Double, var fiat:Double, var smartcontract:Smartcontract, var courseprice:Int) extends Human(name, surname, age, email, addr) with Connect_with_birga with Connect_with_platform {
  private var _login:String = login;
  private var _password:String = password;
  private var _balance:Double = balance;
  private var _fiat:Double = fiat;
  private var _smartcontract:Smartcontract = smartcontract;
  private var _listStudent = new ListBuffer[Student]();
  private var _numofstudent:Int = _listStudent.length;
  private var _courseprice:Int = courseprice;
  override def toString(): String = super.toString() +  s", ${_numofstudent}" + s", ${_balance}" +s", ${_fiat}" + s", ${_courseprice}" + s", ${_smartcontract.toString()}";
  override def Show(): String = super.Show() + s"\nNumber of student: ${_numofstudent}\n" + s"Balance: ${_balance}\n" + s"Fiat: ${_fiat}\n"+ s"Courseprice: ${_courseprice}\n"+  s"Smartcontract: ${_smartcontract.toString()}\n";
  def addinlist(student:Student):Unit ={
    if(_smartcontract.profit == student.smartcontract.profit &&  _smartcontract.period == student.smartcontract.period && _smartcontract.percentage_part == student.smartcontract.percentage_part)
        _listStudent += student;
        _numofstudent = _listStudent.length;
  } 
  def showlist():String = {
    var data:String = "";
      for(i<-0 until _listStudent.length){
        data += _listStudent(i).Show();
      }
    return data;
  }
  def evaluation(birga:Birga, platform:Platform):Unit = {
    if(_balance < _courseprice){
      var toup:Tuple2[Double, Double] =buy((_courseprice - _balance), birga, _balance, _fiat)
            _balance = toup._1;
            _fiat = toup._2;
    }
    var newvalueplatformtokens = platform.get_amount_tokens + _courseprice;
    platform.set_amount_tokens(newvalueplatformtokens);
    _balance = _balance-_courseprice;
    var bal = 0;
    for( i<-0 until Smartcontract.period){
      for(i<-0 until _listStudent.length){
        var grade = Random.nextInt(5);
        if(grade == 4){
          if(birga.get_price>1.5){
             _listStudent -= _listStudent(i);
            _numofstudent = _listStudent.length;
          }
          var price = _courseprice*1.1;
          give(platform, price);
          var new_st_bal_1 = _listStudent(i).Balance + price;
          _listStudent(i).set_balance(new_st_bal_1, birga, platform, _courseprice);
          if(_listStudent(i).Balance<_courseprice){
            var toup:Tuple2[Double, Double] =_listStudent(i).buy((_courseprice-_listStudent(i).Balance), birga, _listStudent(i).Balance, _listStudent(i).Fiat)
            _listStudent(i).set_balance(toup._1, birga, platform, _courseprice);
            _listStudent(i).set_fiat(toup._2);
            
          }
          var new_st_bal_2 = _listStudent(i).Balance - _courseprice;
          
          _listStudent(i).set_balance(new_st_bal_2,  birga, platform, _courseprice);
          if(_listStudent(i).Balance>_courseprice){
            var toup:Tuple2[Double, Double] =_listStudent(i).sell((_listStudent(i).Balance - _courseprice), birga, _listStudent(i).Balance, _listStudent(i).Fiat)
            _listStudent(i).set_balance(toup._1, birga, platform, _courseprice);
            _listStudent(i).set_fiat(toup._2);
          }
          _balance = _balance + _courseprice/2;
          get(platform, _courseprice);
          if(_balance > _courseprice){
                var toup:Tuple2[Double, Double] =sell((_balance-_courseprice), birga, _balance, _fiat)
                _balance = toup._1;
                _fiat = toup._2;
            }
          if(birga.get_price < 0.5){
            platform.buy(_courseprice, birga, platform.get_amount_tokens, platform.get_fiat);
          }
          
        }
        if(grade == 3){
          if(birga.get_price>1.5){
             _listStudent -= _listStudent(i);
            _numofstudent = _listStudent.length;
          }
          var price = _courseprice*1;
          give(platform, price);
          var new_st_bal_1 = _listStudent(i).Balance + price;
          _listStudent(i).set_balance(new_st_bal_1, birga, platform, _courseprice);
          if(_listStudent(i).Balance<_courseprice){
            var toup:Tuple2[Double, Double] = _listStudent(i).buy((_courseprice-_listStudent(i).Balance), birga, _listStudent(i).Balance, _listStudent(i).Fiat)
            _listStudent(i).set_balance(toup._1, birga, platform, _courseprice);
            _listStudent(i).set_fiat(toup._2);
          }
          var new_st_bal_2 = _listStudent(i).Balance - _courseprice;
          _listStudent(i).set_balance(new_st_bal_2, birga, platform, _courseprice);
          if(_listStudent(i).Balance>_courseprice){
            var toup:Tuple2[Double, Double] =_listStudent(i).sell((_listStudent(i).Balance - _courseprice), birga, _listStudent(i).Balance, _listStudent(i).Fiat)
            _listStudent(i).set_balance(toup._1, birga, platform, _courseprice);
            _listStudent(i).set_fiat(toup._2);
          }
          _balance = _balance + _courseprice/2;
          get(platform, _courseprice);
          if(_balance > _courseprice){
                var toup:Tuple2[Double, Double] =sell((_balance-_courseprice), birga, _balance, _fiat)
                _balance = toup._1;
                _fiat = toup._2;
            }
          if(birga.get_price < 0.5){
            platform.buy(_courseprice, birga, platform.get_amount_tokens, platform.get_fiat);
          }
        }
        if(grade == 2){
          if(birga.get_price>1.5){
             _listStudent -= _listStudent(i);
            _numofstudent = _listStudent.length;
          }
          var price = _courseprice*0.8;
          give(platform, price);
          var new_st_bal_1 = _listStudent(i).Balance + price - (_courseprice - price);
          _listStudent(i).set_balance(new_st_bal_1, birga, platform, _courseprice);
          if(_listStudent(i).Balance<_courseprice){
            var toup:Tuple2[Double, Double] = _listStudent(i).buy((_courseprice-_listStudent(i).Balance), birga, _listStudent(i).Balance, _listStudent(i).Fiat)
            _listStudent(i).set_balance(toup._1, birga, platform, _courseprice);
            _listStudent(i).set_fiat(toup._2);
          }
          var new_st_bal_2 = _listStudent(i).Balance - _courseprice;
          _listStudent(i).set_balance(new_st_bal_2, birga, platform, _courseprice);
          if(_listStudent(i).Balance>_courseprice){
            var toup:Tuple2[Double, Double] =_listStudent(i).sell((_listStudent(i).Balance - _courseprice), birga, _listStudent(i).Balance, _listStudent(i).Fiat)
            _listStudent(i).set_balance(toup._1, birga, platform, _courseprice);
            _listStudent(i).set_fiat(toup._2);
          }
          _balance = _balance + _courseprice/2;
          get(platform, _courseprice);
          if(_balance > _courseprice){
                var toup:Tuple2[Double, Double] =sell((_balance-_courseprice), birga, _balance, _fiat)
                _balance = toup._1;
                _fiat = toup._2;
            }
          if(birga.get_price < 0.5){
            platform.buy(_courseprice, birga, platform.get_amount_tokens, platform.get_fiat);
          }
         
        }
        if(grade == 1){
          if(birga.get_price>1.5){
             _listStudent -= _listStudent(i);
            _numofstudent = _listStudent.length;
          }
         var price = _courseprice*0.7;
          give(platform, price);
          var new_st_bal_1 = _listStudent(i).Balance + price - (_courseprice - price);
          _listStudent(i).set_balance(new_st_bal_1, birga, platform, _courseprice);
          if(_listStudent(i).Balance<_courseprice){
            var toup:Tuple2[Double, Double] = _listStudent(i).buy((_courseprice-_listStudent(i).Balance), birga, _listStudent(i).Balance, _listStudent(i).Fiat)
            _listStudent(i).set_balance(toup._1, birga, platform, _courseprice);
            _listStudent(i).set_fiat(toup._2);
          }
          var new_st_bal_2 = _listStudent(i).Balance - _courseprice;
          _listStudent(i).set_balance(new_st_bal_2, birga, platform, _courseprice);
          if(_listStudent(i).Balance>_courseprice){
            var toup:Tuple2[Double, Double] =_listStudent(i).sell((_listStudent(i).Balance - _courseprice), birga, _listStudent(i).Balance, _listStudent(i).Fiat)
            _listStudent(i).set_balance(toup._1, birga, platform, _courseprice);
            _listStudent(i).set_fiat(toup._2);
          }
          _balance = _balance + _courseprice/2;
          get(platform, _courseprice);
          if(_balance > _courseprice){
                var toup:Tuple2[Double, Double] =sell((_balance-_courseprice), birga, _balance, _fiat)
                _balance = toup._1;
                _fiat = toup._2;
            }
          if(birga.get_price < 0.5){
            platform.buy(_courseprice, birga, platform.get_amount_tokens, platform.get_fiat);
          }
        }
        if(grade == 0){
          if(birga.get_price>1.5){
             _listStudent -= _listStudent(i);
            _numofstudent = _listStudent.length;
          }
          var price = _courseprice*0.1;
          give(platform, price);
          var new_st_bal_1 = _listStudent(i).Balance + price - (_courseprice - price);
          _listStudent(i).set_balance(new_st_bal_1, birga, platform, _courseprice);
          if(_listStudent(i).Balance<_courseprice){
            var toup:Tuple2[Double, Double] = _listStudent(i).buy((_courseprice-_listStudent(i).Balance), birga, _listStudent(i).Balance, _listStudent(i).Fiat)
            _listStudent(i).set_balance(toup._1, birga, platform, _courseprice);
            _listStudent(i).set_fiat(toup._2);
          }
              
          var new_st_bal_2 = _listStudent(i).Balance - _courseprice;
          _listStudent(i).set_balance(new_st_bal_2,  birga, platform, _courseprice);
          if(_listStudent(i).Balance>_courseprice){
            var toup:Tuple2[Double, Double] =_listStudent(i).sell((_listStudent(i).Balance - _courseprice), birga, _listStudent(i).Balance, _listStudent(i).Fiat)
            _listStudent(i).set_balance(toup._1, birga, platform, _courseprice);
            _listStudent(i).set_fiat(toup._2);
          }
          _balance = _balance + _courseprice/2;
          get(platform, _courseprice);
          if(_balance > _courseprice){
                var toup:Tuple2[Double, Double] =sell((_balance-_courseprice), birga, _balance, _fiat)
                _balance = toup._1;
                _fiat = toup._2;
            }
          if(birga.get_price < 0.5){
            platform.buy(_courseprice, birga, platform.get_amount_tokens, platform.get_fiat);
          }
        
        }
        println(grade);
        }
      
      
  }
  }

  def Login:String = _login;
  def Login(newValue:String) = {
    _login=newValue;
  }
  def Password:String = _password;
  def Password(newValue:String) = {
    _password=newValue;
  }
  
  def Balance:Double = _balance;
  def set_balance(newValue:Double) = {
    _balance=newValue;
  }
  def Fiat:Double = _fiat;
  def set_fiat(newValue:Double) = {
    _fiat=newValue;
  }
  def Smartcontract:Smartcontract = _smartcontract;
  def Smartcontract(newValue:Smartcontract) = {
    _smartcontract=newValue;
  }
  def Courseprice:Int = _courseprice;
  def Cpurseprice(newValue:Int) = {
    _courseprice=newValue;
  }
  def ListStudent:ListBuffer[Student] = _listStudent;
}