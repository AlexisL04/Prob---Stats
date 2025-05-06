#Author: Alexis Lopez

#This is code to plot the squared values of x

disp("Please enter number of datapoints");
n = input("n: ");

disp("Please enter name of file to write to");
fileName = input(["Name of file: " ], "s");

x = 1:n;
y = x.^2;

data = [x',y'];

csvwrite([fileName, '.csv'] ,data);

plot(x,y);

