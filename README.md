# cv19-mars serverless API
The cv19-mars project, created with [`aws-serverless-java-container`](https://github.com/awslabs/aws-serverless-java-container).

The starter project defines a simple `/ping` resource that can accept `GET` requests with its tests.

The project folder also includes a `template.yml` file. You can use this [SAM](https://github.com/awslabs/serverless-application-model) file to deploy the project to AWS Lambda and Amazon API Gateway or test in local with the [SAM CLI](https://github.com/awslabs/aws-sam-cli). 

## Pre-requisites
* [AWS CLI](https://aws.amazon.com/cli/)
* [SAM CLI](https://github.com/awslabs/aws-sam-cli)
* [Gradle](https://gradle.org/) or [Maven](https://maven.apache.org/)

## Building the project
You can use the SAM CLI to quickly build the project
```bash
$ mvn archetype:generate -DartifactId=cv19-mars -DarchetypeGroupId=com.amazonaws.serverless.archetypes -DarchetypeArtifactId=aws-serverless-jersey-archetype -DarchetypeVersion=1.5 -DgroupId=jw.io -Dversion=1.0-SNAPSHOT -Dinteractive=false
$ cd cv19-mars
$ sam build
Building resource 'Cv19MarsFunction'
Running JavaGradleWorkflow:GradleBuild
Running JavaGradleWorkflow:CopyArtifacts

Build Succeeded

Built Artifacts  : .aws-sam/build
Built Template   : .aws-sam/build/template.yaml

Commands you can use next
=========================
[*] Invoke Function: sam local invoke
[*] Deploy: sam deploy --guided
```

## Testing locally with the SAM CLI

From the project root folder - where the `template.yml` file is located - start the API with the SAM CLI.

```bash
$ sam local start-api

...
Mounting com.amazonaws.serverless.archetypes.StreamLambdaHandler::handleRequest (java8) at http://127.0.0.1:3000/{proxy+} [OPTIONS GET HEAD POST PUT DELETE PATCH]
...
```

Using a new shell, you can send a test ping request to your API:

```bash
$ curl -s http://127.0.0.1:3000/ping | python -m json.tool

{
    "pong": "Hello, World!"
}
``` 

## Deploying to AWS
To deploy the application in your AWS account, you can use the SAM CLI's guided deployment process and follow the instructions on the screen

```
$ sam deploy --guided
```

Once the deployment is completed, the SAM CLI will print out the stack's outputs, including the new application URL. You can use `curl` or a web browser to make a call to the URL

```
...
-------------------------------------------------------------------------------------------------------------
OutputKey-Description                        OutputValue
-------------------------------------------------------------------------------------------------------------
Cv19MarsApi - URL for application            https://xxxxxxxxxx.execute-api.us-west-2.amazonaws.com/Prod/pets
-------------------------------------------------------------------------------------------------------------
```

Copy the `OutputValue` into a browser or use curl to test your first request:

```bash
$ curl -s https://xxxxxxx.execute-api.us-west-2.amazonaws.com/Prod/ping | python -m json.tool

{
    "pong": "Hello, World!"
}
```


## Data - Integrated with restdb.io

1. GET all documents from the case-data-model collection

```

https://cv19mars-9e51.restdb.io/rest/case-data-model

```

2. GET records by query user email

```

https://cv19mars-9e51.restdb.io/rest/case-data-model?q={"userName":"cantrelllindsay@quilch.com"}


Sample Output:

[
    {
        "_id": "5e928c3e5053da7500024860",
        "userName": "Cantrell Lindsay",
        "userEmail": "cantrelllindsay@quilch.com",
        "age": 96,
        "gender": "male",
        "isSmoker": false,
        "condition": {
            "type2Diabetes": false,
            "type1Diabetes": false,
            "hypertension": false,
            "coronaryHeartDiseases": true,
            "copd": false,
            "cancer": true,
            "chronicKidneyDisease": true,
            "other": "ut"
        },
        "selfScreening": {
            "testedPositive": true,
            "dryCough": "none",
            "fever": "none",
            "soreThroat": "mild",
            "fatigue": "severe",
            "shortnessOfBreadth": "severe",
            "lossOfSmell": "mild",
            "lossOfTaste": "moderate",
            "muscleSoreness": "severe",
            "other": "ad",
            "otherLevel": "mild"
        }
    }
]

```

3. POST a new document to the case-data-model collection

```

https://cv19mars-9e51.restdb.io/rest/case-data-model


Body - JSON

{
    "userName": "kevin quinn",
    "userEmail": "kevinquinn@arts.com",
    "age": 18,
    "gender": "male",
    "isSmoker": false,
    "condition": {
        "type2Diabetes": false,
        "type1Diabetes": false,
        "hypertension": false,
        "coronaryHeartDiseases": true,
        "copd": false,
        "cancer": true,
        "chronicKidneyDisease": true,
        "other": "sneezing"
    },
    "selfScreening": {
        "testedPositive": false,
        "dryCough": "none",
        "fever": "none",
        "soreThroat": "mild",
        "fatigue": "severe",
        "shortnessOfBreadth": "severe",
        "lossOfSmell": "mild",
        "lossOfTaste": "moderate",
        "muscleSoreness": "severe",
        "other": "ad",
        "otherLevel": "mild"
    }
}

```

4. PUT an updated record to collection by Object ID


```

https://cv19mars-9e51.restdb.io/rest/case-data-model/{ObjectID}

e.g. https://cv19mars-9e51.restdb.io/rest/case-data-model/5e928c3e5053da7500024860

Body -JSON

{
	"userEmail": "cantrelllindsay@quilch.com",
	"gender": "male"
}

```