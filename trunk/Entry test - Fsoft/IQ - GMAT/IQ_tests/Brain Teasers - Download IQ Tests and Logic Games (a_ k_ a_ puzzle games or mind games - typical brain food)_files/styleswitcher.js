/***********************************************************
autor: Jan Dudek, jan_dudek@seznam.cz

funkce createCookie a readCookie vytvoril Peter-Paul Koch
http://www.quirksmode.org/
***********************************************************/

var BASE="#"	//retezec signalizujici, ze nema byt aktivovan zadny styl
var DAYS="10"	//platnost cookie se zvolenym stylem ve dnech


function createCookie(name,value,days)
{
if (days)
{
var date = new Date();
date.setTime(date.getTime()+(days*24*60*60*1000));
var expires = "; expires="+date.toGMTString();
}
else var expires = "";
document.cookie = name+"="+value+expires+"; path=/";
}


function readCookie(name)
{
var nameEQ = name + "=";
var ca = document.cookie.split(';');
for(var i=0;i < ca.length;i++)
{
var c = ca[i];
while (c.charAt(0)==' ') c = c.substring(1,c.length);
if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
}
return null;
}


function setStyle(title)
{
  var i, p, links = new Array();
  links=document.getElementsByTagName("link");
  for (i=0; i<links.length; i++)
  {
    if ((links[i].getAttribute("rel").indexOf("stylesheet")!=-1) && (p=links[i].getAttribute("title")))
    {
      links[i].disabled=true;
      if ((p==title) && (p!=BASE)) links[i].disabled=false;
    }
  }
}


function getStyle()
{
  var i, p, links;
  links=document.getElementsByTagName("link");
  for (i=0; i<links.length; i++)
  {
    if ((links[i].getAttribute("rel").indexOf("stylesheet")!=-1) && (p=links[i].getAttribute("title")) && (!links[i].disabled))
    {
      return p;
    }
  }
  return BASE;
}


window.onload=window.onclose=function()
{
  var p;
  if (p=readCookie("style"))
  {
    setStyle(p);
  }
}


window.onunload=function()
{
  createCookie("style",getStyle(),DAYS);
}