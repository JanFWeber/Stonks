import pyEX
import json

client = pyEX.Client(api_token = 'Tpk_340be1708c104fc592c0af6497509731', version='sandbox')
#client = pyEX.Client(api_token = 'pk_432538e4010b4b11b081550c64338867')

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
    return data['iexRealtimePrice']

def getChangePercent(symbol):
    data = client.quote(symbol)
    #print(data)
    return data['changePercent']

def getChartData(symbol):
    data = client.chart(symbol)
    return data

def getCompanyName(symbol):
    data = getQuote(symbol)
    return data['companyName']

