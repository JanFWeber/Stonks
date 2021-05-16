import pyEX
import json

#client = pyEX.Client(api_token = 'Tpk_340be1708c104fc592c0af6497509731', version='sandbox')
client = pyEX.Client(api_token = 'pk_432538e4010b4b11b081550c64338867')

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

def getOpen(symbol):
    data = getQuote(symbol)
    return data['open']

def getLow(symbol):
    data = getQuote(symbol)
    return data['low']

def getVolume(symbol):
    data = getQuote(symbol)
    return data['volume']

def getHigh(symbol):
    data = getQuote(symbol)
    return data['high']

def getPeRatio(symbol):
    data = getQuote(symbol)
    return data['peRatio']

def getMktCap(symbol):
    data = getQuote(symbol)
    return data['marketCap']

def getHigh52(symbol):
    data = getQuote(symbol)
    return data['week52High']

def getLow52(symbol):
    data = getQuote(symbol)
    return data['week52Low']

def getAvgVolume(symbol):
    data = getQuote(symbol)
    return data['avgTotalVolume']

#def getEps(symbol):
#   data = getQuote(symbol)
#  return data['']



#print(getQuote('AAPL'))
