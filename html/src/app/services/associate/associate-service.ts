﻿import {associate} from "../../domain/associate/associate";
import {Injectable} from "angular2/core";
import {Http, Response, Headers, RequestOptions} from "angular2/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

@Injectable()
export class AssociateService {
    constructor(private _http: Http) { }
    private _apiUrl: string = "https://eventex.herokuapp.com/associate";

    getList() {
        return this._http.get(this._apiUrl)
            .map(res => res.json())
            .catch(this.throwError);
    }

    private throwError(response) {
        return Observable.throw(response.json().error || "Server error")
    }
}