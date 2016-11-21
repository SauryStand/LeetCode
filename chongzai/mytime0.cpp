#include <iostream>
#include "mytime0.h"
Time::Time(){
	hour = minutes = 0;
}
Time::Time(int h,int m){
	hour = h;
	minutes = m;
}
void Time::AddMin(int m){
	minutes += m;
	hours += minutes/60;
	minutes %= 60;
}
void Time::AddHr(int h){
	hour += h;
}
void Time:Reset(int h,int m){
	hour = h;
	minutes = m;
}
Time Time:Sum(const Time & t)const{
	Time sum;
	sum.minutes = minutes + t.minutes;
	sum.hours = hours + t.hours + t.minutes / 60;
	sum.minutes %= 60;
	return sum;
}
void Time::Show()const{
	std::cout<<hours<<"hours,"<<minutes<<" minutes";
}

