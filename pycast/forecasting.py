#!pip install qbstyles
#!pip install pystan
#!pip install fbprophet
import warnings; 
warnings.simplefilter('ignore')
from qbstyles import mpl_style
mpl_style(dark=True)
import numpy as np
from math import pi,sin
import matplotlib.pyplot as plt
import pandas as pd
from fbprophet import Prophet
import pandas_datareader as pdr
key="7f689ebe475fb98fa72ea483f5c514273d0cd7d9"


def line_plot(na,df,forecast):
    name=na
    plt.xlabel('Time')
    plt.ylabel('Price')
    plt.plot(df['ds'],df['y'])
    plt.plot(forecast['ds'],forecast['yhat'],color='green')
    plt.plot(forecast['ds'],forecast['trend'],color='orange')
    plt.tight_layout()
    plt.legend(["Real", "Forecast","Trend"], loc ="upper left")
    img=na+'.png'
    #print(img)
    plt.savefig(img,pad_inches = 10,quality = 100)
    plt.clf()

    
for i in stocklist:
  df = pdr.get_data_tiingo(i, api_key=key)
  name=i+'.csv'
  df.to_csv(name)
  filenames.append(name)

  
for i in filenames:
  df = pd.read_csv(i)
  df.drop(['symbol', 'high', 'low', 'open', 'volume',
           'adjClose','adjHigh','adjLow','adjOpen',
           'adjVolume','divCash','splitFactor'],
            axis=1, inplace=True)
  df['Year'] = df['date'].apply(lambda x: str(x)[:-21])
  df['Month'] = df['date'].apply(lambda x: str(x)[5:7])
  df['Day'] = df['date'].apply(lambda x: str(x)[8:10])
  df['ds'] = pd.DatetimeIndex(df['Year']+'-'+df['Month']+'-'+df['Day']) 
  df.drop(['Year','Month','Day','date'], axis = 1, inplace = True)
  df.columns = ['y', 'ds']
  name='df_'+i
  df.to_csv(name)
  mod = Prophet(interval_width=0.95,
                daily_seasonality=True,
                changepoint_prior_scale=0.001,
                seasonality_prior_scale=0.01)
  model = mod.fit(df)
  future = mod.make_future_dataframe(periods=200,freq='D')
  forecast = mod.predict(future) 
  name2 = 'forecast_'+i
  df.to_csv(name2)
  na=i[:-4]
  #print(na)
  line_plot(na,df,forecast)  
