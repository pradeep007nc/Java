package dev.pradeep.ReminderAppBackend.Dtos;

public class ErrorResponseDto {
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ErrorResponseDto)) {
            return false;
        } else {
            ErrorResponseDto other = (ErrorResponseDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ErrorResponseDto;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        return result;
    }

    public String toString() {
        return "ErrorResponseDto(message=" + this.getMessage() + ")";
    }

    public ErrorResponseDto(final String message) {
        this.message = message;
    }

    public ErrorResponseDto() {
    }
}