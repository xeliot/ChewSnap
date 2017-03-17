# -*- coding: utf-8 -*-
"""
Created on Thu Mar 16 22:56:13 2017

@author: Dave Ho
"""

from flask import Flask
from flask import request
import json as mjson
import ast
import sqlite3

app = Flask(__name__)

@app.route("/", methods=["GET", "POST"])
def hello():
    #if request.method == "GET":
    print "someone said get"
    return "What's up santosh"
    

@app.route("/login", methods=["GET", "POST"])
def request_login():
    print "user requesting login"
    pass

@app.route("/signup", methods=["GET", "POST"])
def request_signup():
    print "user requesting singup"
    pass

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=80)
    #app.run(host='0.0.0.0',port="80")