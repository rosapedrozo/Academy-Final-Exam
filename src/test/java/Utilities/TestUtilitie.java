package Utilities;

public class TestUtilitie {

        public static boolean validSortestReuslt(String firstOne, String secondOne){

            String[]  firstTime = firstOne.split(" ");
            String[]  secondTime = secondOne.split(" ");

            int hoursFirstTime = Integer.parseInt(String.valueOf(firstTime[0].charAt(0)));
            int hoursSecondTIme = Integer.parseInt(String.valueOf(secondTime[0].charAt(0)));
            System.out.println(hoursFirstTime + " "+ hoursSecondTIme);
            if(hoursFirstTime <= hoursSecondTIme){
                if(hoursFirstTime < hoursSecondTIme){
                    return true;
                }else{
                    int indexOne = firstTime[1].charAt(1) == 'm'? 1:2;
                    int indexTwo = secondTime[1].charAt(1)=='m'?1:2;
                    int minutesFirstTime =  indexOne == 1 ? Integer.parseInt(String.valueOf(firstTime[1].charAt(0))):Integer.parseInt(String.valueOf(firstTime[1].charAt(0)) + String.valueOf(firstTime[1].charAt(1)));
                    int minutesSecondTIme = indexTwo == 1 ? Integer.parseInt(String.valueOf(secondTime[1].charAt(0))):Integer.parseInt(String.valueOf(secondTime[1].charAt(0))+ String.valueOf(secondTime[1].charAt(1)));
                    System.out.println(minutesFirstTime + " "+ minutesSecondTIme);
                    if(minutesFirstTime < minutesSecondTIme){

                        return true;
                    }else{
                        return false;
                    }
                }
                //return true;
            }else {
                return false;
            }
        }
    }

