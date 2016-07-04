import {Http} from "angular2/http";
import {Observable} from "rxjs/Observable";
import {Injectable} from "angular2/core";

@Injectable()
export class BaseService {
    protected _baseUrl: string;
    private _apiUrl: string;

    constructor() {
        this._baseUrl = "http://eventex.herokuapp.com";
    }

    constructor(private _http: Http) {
        super();
        this._apiUrl = this._baseUrl + "/events";
    }

    public getList() {
        return this._http.get(this._apiUrl)
            .map(res => res.json())
            .catch(this.throwError);
    }

    public save(domain:Event) {
        let body = JSON.stringify(domain);

        return this._http.post(this._apiUrl, body)
            .toPromise()
            .then(res => res.json())
            .catch(this.throwError);
    }

    public del(domain:Event) {
        return this._http.delete(this._apiUrl + "/" + domain.id)
            .toPromise()
            .catch(this.throwError);
    }

    private throwError(response) {
        return Observable.throw(response.json().error || "Server error")
    }
}
