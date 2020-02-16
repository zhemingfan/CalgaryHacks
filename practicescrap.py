from bs4 import BeautifulSoup
import urllib.request

website = "http://contacts.ucalgary.ca/info/cpsc/contact-us/directory"
page = urllib.request.urlopen(website) 

print(page)
soup = BeautifulSoup(page, features="html.parser")

#print(soup.prettify())

'''
all = soup.find_all("Professor")
for link in all:
	print(link.get("href"))
'''

all_tables=soup.find_all('table')
#print(all_tables)

data = []

'''
for i in range(25): 
	num = 'uofc-table-' + str(i+1)
	table = soup.find('table', id=(num))

	i = int(i) + 1
	table_body = table.find('tbody')
	rows = table_body.find_all('tr')

	for row in rows:
		cols = row.find_all('td')
		cols = [ele.text.strip() for ele in cols]

		for x in row.find_all('a', href = True):
			data.append(x)
			data.append([ele for ele in cols if cols]) # Get rid of empty values

print(data)
'''

for i in range(25): 
	num = 'uofc-table-' + str(i+1)
	table = soup.find('table', id=(num))

	i = int(i) + 1
	table_body = table.find('tbody')
	rows = table_body.find_all('tr')

	for row in rows:
		cols = row.find_all('td')
		cols = [ele.text.strip() for ele in cols]

		for i in range(2):
			for x in cols:
				if x == '':
					cols.remove(x)

		for x in row.find_all('a', href = True):
			cols.append(x)
			data.append([ele for ele in cols if cols]) # Get rid of empty values

print(data)


