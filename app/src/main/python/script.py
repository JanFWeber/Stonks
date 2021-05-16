import pyEX
import json

#client = pyEX.Client(api_token = 'Tpk_340be1708c104fc592c0af6497509731', version='sandbox')
client = pyEX.Client(api_token = 'pk_432538e4010b4b11b081550c64338867')
quote = {}

def setQuote(symbol):
    global quote
    quote = getQuote(symbol)

def getSymbol(symbol):
    return symbol

def getAdvancedStats(symbol):
    return client.advancedStats(symbol)

def getQuote(symbol):
    return client.quote(symbol)

def getLogoLink(symbol):
    data = client.logo(symbol)
    return data['url']

def getPrice(symbol):
    data = client.quote(symbol)
    if data['iexRealtimePrice'] == 'None':
        return data['iexRealtimePrice']
    else:
        return data['latestPrice']

def getChangePercent(symbol):
    data = getQuote(symbol)
    #print(data)
    return data['changePercent']

def getChartData(symbol):
    data = client.chart(symbol)
    return data

def getCompanyName(symbol):
    data = getQuote(symbol)
    return data['companyName']

#setQuote muss einmal zuvor aufgerufen worden sein
def getOpen(symbol):
    return quote['open']

def getLow(symbol):
    data = getQuote(symbol)
    return data['low']

def getVolume(symbol):
    return quote['volume']

def getHigh(symbol):
    return quote['high']

def getPeRatio(symbol):
    return quote['peRatio']

def getMktCap(symbol):
    return quote['marketCap']

def getHigh52(symbol):
    return quote['week52High']

def getLow52(symbol):
    return quote['week52Low']

def getAvgVolume(symbol):
    return quote['avgTotalVolume']

#def getEps(symbol):
#  quote data['']


setQuote('AAPL')
#print(quote)
print(getMktCap('AAPL'))
