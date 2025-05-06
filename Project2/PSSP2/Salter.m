#Author: Alexis Lopez

#This is code to salt the values of y within the range set by the user

disp("Please enter csv to extract from: ");
fileExtract = input("fileExtract: ", "s");

disp("Please enter csv to write to ");
fileName = input("fileName: ", "s");

data = csvread(fileExtract);

x = data(:,1);
y = data(:,2);

disp("Please enter range of salting");
range = input("range: ")

for i = 1:length(x);
  y(i) = y(i) + randi([-range,range]);
endfor

data = [x,y];

csvwrite([fileName, '.csv'] ,data);

plot(x,y);

