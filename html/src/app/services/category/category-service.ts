﻿import {category} from "../../domain/category/category";
import {Injectable} from "angular2/core";
import {Http, Response, Headers, RequestOptions} from "angular2/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";
import {BaseService} from "../base-service";

@Injectable()
export class CategoryService extends BaseService {
    private _apiUrl: string;

    constructor(private _http: Http) {
        super();
        this._apiUrl = this._baseUrl + "/categories";
    }

    public getList() {
        return this._http.get(this._apiUrl)
            .map(res => res.json())
            .catch(this.throwError);
    }

    public save(domain: activity) {
        let body = JSON.stringify(domain);

        return this._http.post(this._apiUrl, body)
            .toPromise()
            .then(res => res.json())
            .catch(this.throwError);
    }

    private throwError(response) {
        return Observable.throw(response.json().error || "Server error")
    }
}
