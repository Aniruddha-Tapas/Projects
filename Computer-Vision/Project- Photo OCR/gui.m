function varargout = gui(varargin)
% GUI MATLAB code for gui.fig
%      GUI, by itself, creates a new GUI or raises the existing
%      singleton*.
%
%      H = GUI returns the handle to a new GUI or the handle to
%      the existing singleton*.
%
%      GUI('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in GUI.M with the given input arguments.
%
%      GUI('Property','Value',...) creates a new GUI or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before gui_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to gui_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help gui

% Last Modified by GUIDE v2.5 02-Nov-2015 13:59:00

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @gui_OpeningFcn, ...
                   'gui_OutputFcn',  @gui_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before gui is made visible.
function gui_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to gui (see VARARGIN)

% Choose default command line output for gui
handles.output = hObject;
axes(handles.background);
imshow('background1.jpg');
axes(handles.axes3);
imshow('logo.jpg');
axes(handles.selected_image);
imshow('IMG.jpg');
axes(handles.edited);
imshow('IMG1.jpg');
% Update handles structure
guidata(hObject, handles);

% UIWAIT makes gui wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = gui_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in select_image.
function select_image_Callback(hObject, eventdata, handles)
% hObject    handle to select_image (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
%clear all;
%close all;
%clc;
[FileName,path] = uigetfile('*.jpg;*.png;*.jpeg;*.bmp;*.tif','Pick an image file');
FileName=strcat(path,FileName);
im=imread(FileName);
axes(handles.selected_image);
imshow(im);
% dpi = 180;
% im = imresize(im,300/dpi);
TH = binarize(im);
axes(handles.edited);
imshow(TH);
pause(1);
th = skew(TH);
axes(handles.edited);
imshow(th);
pause(1);
th = im2bw(th,0.5);
axes(handles.edited);
imshow(th);
pause(1);
CC = bwconncomp(th);

m1 = CC.NumObjects;
rn = CC.ImageSize(1);
enough = CC.PixelIdxList;

%boxmat stores the binary from of an Image in Matrix
boxmat = zeros(m1,5);
for i = 1:m1
    temp = enough{1,i};
    temp1 = mod(temp,rn*ones(size(temp)));
    temp2 = ceil(temp./rn);
    boxmat(i,1) = min(temp1);
    boxmat(i,2) = min(temp2);
    boxmat(i,3) = max(temp1);
    boxmat(i,4) = max(temp2);
    boxmat(i,5) = (boxmat(i,3)-boxmat(i,1))*(boxmat(i,4)-boxmat(i,2));
end

ind = mean(boxmat(:,5))/8;
for i = 1:m1
    if boxmat(i,5) < ind
        th(enough{1,i}) = 0;
        boxmat(i,:) = 0;
    end
end

boxmat = sortrows(boxmat,1);
sb=size(boxmat,1);
i = 1;
while boxmat(i,1)==0 && i<sb
    i = i+1;
end
boxmat = boxmat(i:m1,:);
boxfinal = sortcol(boxmat);
m2 = size(boxfinal,1);

testmat = zeros(m2,1024);
p3=zeros(m2,2);
for i = 1:m2
temp = th(boxfinal(i,1):boxfinal(i,3),boxfinal(i,2):boxfinal(i,4));
p3(i,1)=boxfinal(i,3)-boxfinal(i,1);
p3(i,2)=boxfinal(i,4)-boxfinal(i,2);


%fvect helps to resize sorted images in 32*32
temp = fvect(temp);
testmat(i,:) = temp;
end

%alligns the ambiguous images
p = predictnn(testmat);
axes(handles.selected_image);
imshow(p);
p1 = zeros(m2,1);
for i = 1:m2-1
    p1(i) = boxfinal(i+1,2)-boxfinal(i,4);
end
m3 = find(p1>0);
ind2 = mean(p1(m3));
p2 = zeros(m2,1);
ind21 = ind2*1.5;
ind22 = ind2*(-10);
for i = 1:m2
    if p1(i)>ind21
        p2(i) = 1;
    end
    if p1(i) < ind22
        p2(i) = 2;
    end
end

p = [p p2 p3];

x=zeros(size(p,1),1);
for i=1:size(p,1)
x(i,1)=p(i,4)/p(i,3);
end

p = [p x];

%gi0ves key for each segment

key = ['0';'1';'2';'3';'4';'5';'6';'7';'8';'9';'A';'B';'C';'D';'E';'F';'G';'H';'I';'J';'K';'L';'M';'N';'O';'P';'Q';'R';'S';'T';'U';'V';'W';'X';'Y';'Z';'a';'b';'c';'d';'e';'f';'g';'h';'i';'j';'k';'l';'m';'n';'o';'p';'q';'r';'s';'t';'u';'v';'w';'x';'y';'z'];

file = [FileName(1:end-4) '.txt'];

fileID = fopen(file,'w');
for i = 1:size(p,1)
    if p(i,2)==0
        fprintf(fileID,'%1s',key(p(i,1)));
    elseif p(i,2) == 1
        fprintf(fileID,'%1s ',key(p(i,1)));
    else
        fprintf(fileID,'%1s\n',key(p(i,1)));
    end
end
fclose(fileID);
open(file);
axes(handles.selected_image);
imshow(im);

% --- Executes on button press in convert_to_text.
function convert_to_text_Callback(hObject, eventdata, handles)
% hObject    handle to convert_to_text (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)



function converted_text_Callback(hObject, eventdata, handles)
% hObject    handle to converted_text (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of converted_text as text
%        str2double(get(hObject,'String')) returns contents of converted_text as a double


% --- Executes during object creation, after setting all properties.
function converted_text_CreateFcn(hObject, eventdata, handles)
% hObject    handle to converted_text (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end
