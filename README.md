# Assessment Testing

## For find Highest common factor
Post
http://localhost:8085/api/v1/highest/number?numbers=54&numbers=24


## Apis call forr Address

### pretty print Post
http://localhost:8085/api/v1/address/prettyPrintAddress

Json body
{
"id": "1",
"type": {
"code": "1",
"name": "Physical Address"
},
"addressLineDetail": {
"line1": "Address 1",
"line2": "Line 2"
},
"provinceOrState": {
"code": "5",
"name": "Eastern Cape"
},
"cityOrTown": "City 1",
"country": {
"code": "ZA",
"name": "South Africa"
},
"postalCode": "1234",
"lastUpdated": "2015-06-21T00:00:00.000Z"
}

### function to pretty print all the addresses in the attached file  Post

http://localhost:8085/api/v1/address/prettyPrintAddressList

Json

[
{
"id": "1",
"type": {
"code": "1",
"name": "Physical Address"
},
"addressLineDetail": {
"line1": "Address 1",
"line2": "Line 2"
},
"provinceOrState": {
"code": "5",
"name": "Eastern Cape"
},
"cityOrTown": "City 1",
"country": {
"code": "ZA",
"name": "South Africa"
},
"postalCode": "1234",
"lastUpdated": "2015-06-21T00:00:00.000Z"
},
{
"id": "2",
"type": {
"code": "2",
"name": "Postal Address"
},
"cityOrTown": "City 2",
"country": {
"code": "LB",
"name": "Lebanon"
},
"postalCode": "2345",
"lastUpdated": "2017-06-21T00:00:00.000Z"
},
{
"id": "3",
"type": {
"code": "5",
"name": "Business Address"
},
"addressLineDetail": {
"line1": "Address 3",
"line2": ""
},
"cityOrTown": "City 3",
"country": {
"code": "ZA",
"name": "South Africa"
},
"postalCode": "3456",
"suburbOrDistrict": "Suburb 3",
"lastUpdated": "2018-06-13T00:00:00.000Z"
}
]


### function to validate an address = Post

http://localhost:8085/api/v1/address/validate


Invalid json

    {
        "id": "2",
        "type": {
            "code": "2",
            "name": "Postal Address"
        },
        "cityOrTown": "City 2",
        "country": {
            "code": "LB",
            "name": "Lebanon"
        },
        "postalCode": "2345",
        "lastUpdated": "2017-06-21T00:00:00.000Z"
    }



###  function to print an address of a certain type (postal, physical, business)

Post
http://localhost:8085/api/v1/address/addressType


Json


    {
        "id": "2",
        "type": {
            "code": "2",
            "name": "Postal Address"
        },
        "cityOrTown": "City 2",
        "country": {
            "code": "LB",
            "name": "Lebanon"
        },
        "postalCode": "2345",
        "lastUpdated": "2017-06-21T00:00:00.000Z"
    }
