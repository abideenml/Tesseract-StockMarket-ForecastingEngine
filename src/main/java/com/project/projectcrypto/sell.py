API_KEY = 'PK5R4ARORC9WEOG38Q4M'
SECRET_TOKEN = 'JkJUKGbJMhGuBHmIGSU8cLXYNJLHNEvoG9AFSqtW'
BASE_URL = 'https://paper-api.alpaca.markets'
import alpaca_trade_api as tradeapi
api = tradeapi.REST(
    base_url = BASE_URL,
    key_id = API_KEY,
    secret_key = SECRET_TOKEN
)
account = api.get_account()
if account.trading_blocked:
  print("Your Account is restricted from trading.")
print("${} is available as buying power".format(account.buying_power))
balance_change = float(account.equity) - float(account.last_equity)
print(f'today portfolio balance changes: ${balance_change}')

# ticker="GOOG"
# quantity=1
# print(type(quantity))
# side="buy"
# type= "market"

file = open("C:\\Users\\HPP\\ProjectCrypto\\sell.txt","r")
text = file.readlines()
ticker = text[0]

if (ticker[0:4] == "FORD" ):
    ticker = "F"

elif (ticker[0:4] == "HPCO" ):
    ticker = "HPQ"

elif (ticker[0:4] == "TSLA" ):
    ticker = "TSLA"

elif (ticker[0:4] == "GOOG" ):
    ticker = "GOOG"

elif (ticker[0:4] == "MSFT" ):
    ticker = "MSFT"
else:
    ticker = "AAPL"

quantity = int(text[1])
ordertype = text[2]
side = text[3]
file.close()

print(ticker)
print (quantity)
print (ordertype)
print (side)
order = api.submit_order(symbol = ticker,qty = quantity,side=side, type="market", time_in_force= 'day')

print("order")
f = open("orders.txt","a")
f.write("Sell \n")
f.write(ticker+ "\n")
f.write(str(quantity)+ "\n")
f.write(str(ordertype))
# f.write(side+ "\n")
f.close()
