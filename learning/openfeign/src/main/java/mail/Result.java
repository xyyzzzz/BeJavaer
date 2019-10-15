package mail;


/**
 * result结构和dbc返回的结构保持一致
 *
 * @author christ
 * @date 2016/11/16
 */
public class Result<T> {

    private long ret;
    private T data;
    private Integer statusCode;
    private Integer bizCode;

    private Error error;

    public long getRet() {
        return ret;
    }

    public Result setRet(long ret) {
        this.ret = ret;
        return this;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public Result setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public Integer getBizCode() {
        return bizCode;
    }

    public Result setBizCode(Integer bizCode) {
        this.bizCode = bizCode;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public Error getError() {
        return error;
    }

    public Result setError(Error error) {
        this.error = error;
        return this;
    }

    //----------------------helper-------------------

    public Result error(Error error) {
        this.ret = -1;
        this.setError(error);
        return this;
    }

}
