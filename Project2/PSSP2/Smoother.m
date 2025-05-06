#Author: Alexis Lopez

#This is code to salt the values of y within the range set by the user

disp("Please enter csv to extract from: ");
fileExtract = input("fileExtract: ", "s");

disp("Please enter csv to write to ");
fileName = input("fileName: ", "s");

data = csvread(fileExtract);

x = data(:,1);
y = data(:,2);

disp("Please enter window range");
range = input("range: ")

for i = 1:length(x);
  start = max(1, i-range);
  endVal = min(length(x), i+range);
  y(i) = mean(y(start:endVal));
endfor

data = [x,y];

csvwrite([fileName, '.csv'] ,data);

plot(x,y);

