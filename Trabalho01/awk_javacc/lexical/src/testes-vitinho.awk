##HAPPY PATH
#Programa vazio
{{}}

#BEGIN e end PATTERN
BEGIN { print "Beginning..." }
{}
END { print "...Ended!"}

#Comando sem ; no final
{
	print "ponto e virgula";
}

#if (tem que testar o else, mas ele não está funcionando)
{
 if($1 == a)
   print "a";
 else
   print"nao eh a";
}

#for 1
{
  for(x=0; x<=4; x++)
    print x;
}

#for 2
{
  count[""]=0;
  for(x in count)
    print x;
}


#while
{
  x=5;
  while(x>0){
    print x;
	x--;
	}
}

#do while
{
  x=5;
  do{
    print x;
	x--;
  }while(x>0)
}


#break
{
  x=5;
  while(x>0){
    print x;
	x--;
	break;
	}
}

#delete
{
  arr[3];
  for(x in arr){
	arr[x] = x;
  }
  delete arr;
}

#exit
{
  exit;
}

##SAD PATH
#Programa vazio	?
{{}}

#BEGIN e end PATTERN
{
  BEGIN { print "Beginning..."; }
}
END { print "...Ended!";}

#Comando sem ; no final
{
	print "ponto e virgula"
}

#if (tem que testar o else, mas ele não está funcionando)
{
 else
   print"nao eh a";
 if($1 == a)
   print "a";
}

#for 1
{
  for(x=0 x<=4; x++)
    print x;
}

#for 2
{
  count[""]=0;
  for(x inn count)
    print x;
}


#while
{
  x=5;
  while(){
    print x;
	x--;
  }
}

#do while
{
  x=5;
  do{
    print x;
	x--;
  }while();
}


#break
{
  x=5;
  while(x>0){
    print x;
	x--;
  }
  break;
}

#delete
{
  arr[3];
  for(x in arr){
	arr[x] = x;
  }
  delete ;
}

#exit
{
  x = exit;
}

