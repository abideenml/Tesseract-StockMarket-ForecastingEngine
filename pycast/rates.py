import pandas as pd

stocklist=['TSLA','AAPL','MSFT','F','HPQ','GOOG']
rates = []

def slope(data):
  first = data.loc[1228, 'close']
  last = data.loc[1255,'close']
  diff = (last - first)/30
  diff = round(diff,2)
  rates.append(diff)
  return diff


f = open("rates.txt", "w") 
for i in stocklist:
  df = pd.read_csv(i+'.csv')
  df.drop(['symbol', 'high', 'low', 'open', 'volume'
           , 'adjClose','adjHigh','adjLow','adjOpen'
           ,'adjVolume','divCash','splitFactor'],
            axis=1, inplace=True)
  df['Year'] = df['date'].apply(lambda x: str(x)[:-21])
  df['Month'] = df['date'].apply(lambda x: str(x)[5:7])
  df['Day'] = df['date'].apply(lambda x: str(x)[8:10])
  df['ds'] = pd.DatetimeIndex(df['Year']+'-'+df['Month']+'-'+df['Day']) 
  df.drop(['Year','Month','Day','date'], axis = 1, inplace = True)
  data = df.iloc[-40:]
  rate = slope(data)
  f.write(str(rate) + "\n")

