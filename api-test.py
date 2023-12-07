#pip install selenium
import requests
import time



category = { 
    "name": "informatica"
}

product = {
  "nome": "Pen Drive",
  "marca": "San Disck",
  "descricao": "Armazem de dados kkkkkkkkkk",
  "preco": 55,
  "margem": 1.7,
  "precoVenda":93.5 ,
  "quantidade": 100,
  "categoria": {"id": 4}
}

urlc = 'http://localhost:8000/produto-service/categorias'
urlp = 'http://localhost:8000/produto-service/produtos'


for i in range(100):
  post_response = requests.post(url=urlc, json=category)


time.sleep(5)

for i in range(100):
  post_response = requests.post(url=urlp, json=product)

