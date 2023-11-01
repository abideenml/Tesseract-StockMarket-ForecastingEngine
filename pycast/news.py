from gnews import GNews
google_news = GNews()
newslist = ['Tesla', 'Google', 'Microsoft',
            'Ford', 'HP','Apple', 'Stock market']

f = open("news.txt", "w")
for i in newslist:
  news = google_news.get_news(i)
  f.write(i + "\n")
  y=0
  for x in news[0:2]:
     f.write(news[y]['title'] + "\n")
     f.write(news[y]['publisher']['href'])
     f.write(news[y]['publisher']['title'] + "\n")
     f.write(news[y]['published date'] + "\n")
     f.write(news[y]['url'] + "\n")
     f.write("\n")
     y =y+1
f.close()
